package com.dt.hippo.my.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dt.hippo.auto.business.service.mapping.OrderheaderServiceMapper;
import com.dt.hippo.auto.data.repository.jpa.OrderheaderJpaRepository;
import com.dt.hippo.auto.data.repository.jpa.TargetlistJpaRepository;
import com.dt.hippo.auto.data.repository.jpa.UservoucherJpaRepository;
import com.dt.hippo.auto.model.Comboinfo;
import com.dt.hippo.auto.model.Dishspecificationinfo;
import com.dt.hippo.auto.model.Orderheader;
import com.dt.hippo.auto.model.jpa.OrderdetailEntity;
import com.dt.hippo.auto.model.jpa.OrderheaderEntity;
import com.dt.hippo.auto.model.jpa.TargetlistEntity;
import com.dt.hippo.auto.model.jpa.UservoucherEntity;
import com.dt.hippo.business.base.SuperService;
import com.dt.hippo.business.exception.HippoResultException;
import com.dt.hippo.business.model.com.ComboItem;
import com.dt.hippo.business.model.com.OrderCom;
import com.dt.hippo.business.model.com.OrderRowBean;
import com.dt.hippo.business.model.com.StoreInfo;
import com.dt.hippo.my.service.CstBusinessService;
import com.dt.hippo.my.service.CstOrderService;


@Service
public class CstOrderServiceImpl extends SuperService implements CstOrderService
{
    @Resource
    protected OrderheaderJpaRepository orderheaderJpaRepository;

    @Resource
    protected OrderheaderServiceMapper orderheaderServiceMapper;

    @Resource
    protected CstBusinessService cstBusinessService;

    @Resource
    protected UservoucherJpaRepository uservoucherJpaRepository;

    @Resource
    protected TargetlistJpaRepository targetlistJpaRepository;

    @Override
    public List<Orderheader> getPastOrders(Long userId, Long maxOrderId)
    {

        return this.getPastOrders(null, userId, maxOrderId);
    }

    @Override
    public List<Orderheader> getPastOrders(Long storeId, Long userId, Long maxOrderId)
    {
        List<Orderheader> orderbeanList = new ArrayList<Orderheader>();
        List<OrderheaderEntity> orderList = storeId == null ? (maxOrderId != null ? orderheaderJpaRepository
                .findByUseridAndUidLessThan(userId, maxOrderId, commonPage)
                : orderheaderJpaRepository.findByUserid(userId, commonPage))
                : (maxOrderId != null ? orderheaderJpaRepository
                        .findByStoreidAndUseridAndUidLessThan(storeId, userId,
                                maxOrderId, commonPage) : orderheaderJpaRepository
                        .findByStoreidAndUserid(storeId, userId, commonPage));
        for (OrderheaderEntity orderheaderEntity : orderList)
        {
            orderbeanList.add(orderheaderServiceMapper
                    .mapOrderheaderEntityToOrderheader(orderheaderEntity));
        }
        return orderbeanList;
    }

    @Override
    public OrderCom generateNewOrder(OrderCom com, int payMethod)
    {
        // TODO if the count of the unfinished order is more than 5, we need
        // prevent the stupid guy from doing such thing.
        StoreInfo storeInfo = cstBusinessService.getStoreInfo(com.getStoreId());
        String orderno = com.getOrderno();
        // TODO check orderno
        {
            OrderheaderEntity existedOrder = orderheaderJpaRepository
                    .findByOrdernoAndCorpid(orderno, storeInfo.getCorpid());
            if (existedOrder != null)
            {
                // TODO set result
                return com;
            }
        }
        List<OrderRowBean> notMatchItemList = new ArrayList<OrderRowBean>();
        boolean hasVoucher = false;
        List<Long> specificationIdList = new ArrayList<Long>();
        for (OrderRowBean item : com.getListOfItemOrdered())
        {
            // 0 菜品 1 赠券
            if (item.getType() == 0)
            {
                specificationIdList.add(item.getDishVoucherUid());
            }
        }
        UservoucherEntity userVoucher = null;
        Long totalCost = 0l;
        for (OrderRowBean item : com.getListOfItemOrdered())
        {
            // 0 菜品 1 赠券
            if (item.getType() == 0)
            {

                Dishspecificationinfo dish = storeInfo.getBufferForAllDishes().get(
                        item.getDishVoucherUid());

                item.setStandardPrice(dish.getPrice());
                // 0:一般菜点， 1：套餐
                if (item.getType() == 0
                        && !item.getPriceOrValue().equals(dish.getRealprice()))
                {
                    item.setName(dish.getName());
                    item.setPriceOnServer(dish.getRealprice());
                    notMatchItemList.add(item);
                }
                // 0：套餐
                if (item.getType() == 0)
                {
                    totalCost += dish.getRealprice() * item.getAmount();
                }
                else
                {
                    // 1：套餐
                    if (item.getType() == 1)
                    {
                        long priceOnServer = dish.getRealprice();
                        List<ComboItem> comboList = item.getItemListOfCombo();
                        for (ComboItem comboItem : comboList)
                        {
                            Comboinfo comboinfo = dish
                                    .fetchComboinfoWithSpecificationId(comboItem
                                            .getDishSpecificationUid());
                            if (comboinfo == null)
                            {
                                item.setName(dish.getName());
                                // can't find the corresponding combo item, it
                                // should not happen
                                item.setFailReason(1);
                                notMatchItemList.add(item);
                                break;
                            }
                            priceOnServer += comboinfo.getRealPricedifference();
                            // if(comboinfo.getRealPricedifference() !=
                            // comboItem.getPrice())
                            // {
                            //
                            // }
                        }
                        totalCost += priceOnServer * item.getAmount();
                        if (priceOnServer != item.getPriceOrValue())
                        {
                            item.setName(dish.getName());
                            item.setPriceOnServer(priceOnServer);
                            notMatchItemList.add(item);
                        }

                    }
                }
            }
            else
            {
                if (hasVoucher)
                {
                    com.setResult(-1001);
                    return com;
                }
                else
                {
                    hasVoucher = true;
                    // should move below part to voucher service
                    userVoucher = uservoucherJpaRepository.findOne(item
                            .getDishVoucherUid());

                    // the crazy is trying to use the obsolete ticket
                    if (userVoucher.getStatus() != 0)
                    {
                        com.setError(this.getMessage("voucher.used"));
                        return com;
                    }
                    if (!this.isStrictValidDateRange(userVoucher.getApplystartdate(),
                            userVoucher.getApplyenddate()))
                    {
                        com.setError(this.getMessage("voucher.date.range",
                                userVoucher.getApplystartdate(),
                                userVoucher.getApplyenddate()));
                        return com;
                    }
                    if (userVoucher.getOwnerid() > 0)
                    {
                        // this guy try to steal other's Money, let us kill him
                        if (userVoucher.getOwnerid() != this.getCurrentLoginUser()
                                .getDelegateUser().getUid())
                        {
                            com.setResult(-1001);
                            return com;
                        }
                    }
                    // corpid check
                    if (userVoucher.getCorpid() != storeInfo.getCorpid())
                    {
                        HippoResultException.RaiseException(this
                                .getMessage("store.notapplicable"));
                        // return
                    }
                    // is it able to be applied to all the Stores?
                    // 0，全体门店 1，非全体门店（对应表有记录）
                    if (userVoucher.getApplytoallstore() != 0)
                    {
                        // 0，促销目标，1,voucher对应门店目标，2， vouncher菜品目标
                        TargetlistEntity targetlistEnity = targetlistJpaRepository
                                .findByTargetidAndTypeAndCorpidAndTargetvalue(
                                        userVoucher.getVoucherid(), 1,
                                        storeInfo.getCorpid(), storeInfo.getStoreid());
                        if (targetlistEnity == null)
                        {
                            HippoResultException.RaiseException(this
                                    .getMessage("store.notapplicable"));
                            // return
                        }
                    }
                    // is it able to be applied to all the dishes? 0，全体菜品可以应用
                    // 1，非全体菜品（对应表有记录）
                    if (userVoucher.getApplytoalldish() != 0)
                    {
                        // 0，促销目标，1,voucher对应门店目标，2， vouncher菜品目标
                        TargetlistEntity targetlistEnity = targetlistJpaRepository
                                .findByTargetidAndTypeAndCorpidAndTargetvalueIn(
                                        userVoucher.getVoucherid(), 2,
                                        storeInfo.getCorpid(), specificationIdList);
                        if (targetlistEnity == null)
                        {
                            HippoResultException.RaiseException(this
                                    .getMessage("voucher.notapplicable"));
                            // return
                        }
                    }
                    // the value does not equal to the real value, it won't
                    // happen
                    if (!userVoucher.getValue().equals(item.getPriceOrValue()))
                    {
                        HippoResultException.RaiseException(-1001);
                        // return
                    }
                    // if it is refunded with money
                    if (userVoucher.getObjecttosend() == -1)
                    {
                        totalCost -= userVoucher.getValue();
                    }
                }
            }
        }
        if (notMatchItemList.size() > 0)
        {
            com.setListOfItemPriceNotMatch(notMatchItemList);
            return com;
        }
        if (totalCost != com.getTotalCost())
        {
            HippoResultException.RaiseException(this.getMessage("order.moneyNotEqual",
                    com.getTotalCost(), totalCost));
            // return;
        }

        // update the userVoucher status
        long orderId = this.seqenceServiceProxy.getSeqence();
        // this.utils
        // .createReadableOrderNo(orderId);
        if (userVoucher != null)
        {
            // binding the order no
            userVoucher.setOrderuid(orderId);
            // set the status with 1
            userVoucher.setStatus(1);
            // there will be
            this.uservoucherJpaRepository.save(userVoucher);
        }

        List<OrderdetailEntity> orderList = new ArrayList<OrderdetailEntity>();
        int index = 0;
        for (OrderRowBean item : com.getListOfItemOrdered())
        {
            OrderdetailEntity entity = new OrderdetailEntity();
            orderList.add(entity);
            // 流水号 uid
            // 顺序号 no
            entity.setNo(index++);
            // 订单流水号 orderUid
            entity.setOrderuid(orderId);
            // 订单号 orderNo
            entity.setOrderno(orderno);
            // 菜品ID/抵用券编号 itemId
            entity.setItemid(item.getDishVoucherUid());

            // 销售价格 priceAtSale
            entity.setPriceatsale(item.getPriceOrValue());
            if (item.getType() == 0)
            {
                // 价格 price
                entity.setPrice(item.getStandardPrice());
                // 金额 amountMoney
                entity.setAmountmoney(item.getStandardPrice() * item.getAmount());
                // 销售金额 amountAtSale
                entity.setAmountatsale(item.getPriceOrValue() * item.getAmount());
                // 数量 amount
                entity.setAmount(item.getAmount());

                // 当前应用的促销信息 promotionUid
                Dishspecificationinfo dish = storeInfo.getBufferForAllDishes().get(
                        item.getDishVoucherUid());

                entity.setPromotionuid(dish.getPromotioninfo() != null ? dish
                        .getPromotioninfo().getUid() : 0l);
            }
            // 类型 type
            // 0 菜品， 1 赠券
            entity.setType(item.getType());
            if (item.getType() == 1)
            {
                // 动态赠品编号 specificationId
                entity.setSpecificationid(userVoucher.getObjecttosend());
            }

            // 创建时间 createDate
            // 最后更新时间 modifyDate
            // 创建者 createUser
            // 最后更新者 modifyUser
            // 删除标志 delFlg
            // 平台 platform
        }
        OrderheaderEntity orderheaderEntity = new OrderheaderEntity();
        // ID uid
        orderheaderEntity.setUid(orderId);
        // 订单号 orderNo
        orderheaderEntity.setOrderno(orderno);
        // 公司ID corpId
        orderheaderEntity.setCorpid(storeInfo.getCorpid());
        // 父订单号 parentOrderNo
        // leave it null
        // 支付编号 paymentNo
        // null,
        // 交易金额 payAcount
        // orderheaderEntity.setRealpaymentamount(totalCost); //TODO
        // 实际物品金额 acount
        orderheaderEntity.setPaymentamount(totalCost);

        // 交易状态 orderStatus
        orderheaderEntity.setOrderstatus(0);
        // 交易结果信息 orderInfo
        // orderheaderEntity.setOrderinfo(");

        // 支付方式 paymentMethod
        orderheaderEntity.setPaymentmethod(com.getPaymentmethod());
        // 交易时间 tradeDate
        // null
        // 用户代理 useragent
        // null
        // 用户ID userId
        orderheaderEntity.setUserid(this.getCurrentLoginUser().getDelegateUser()
                .getUid());
        // 门店ID storeId
        orderheaderEntity.setStoreid(storeInfo.getStoreid());
        // 食品发放时间 delieverTime
        // null
        // 订单取消时间 cancelTime
        // null
        // 食品确认已经领取时间 confirmTime
        // null
        // 用户IP信息 ip
        // null
        orderheaderJpaRepository.save(orderheaderEntity);
        // TODO set back to com
        return com;
    }

}
