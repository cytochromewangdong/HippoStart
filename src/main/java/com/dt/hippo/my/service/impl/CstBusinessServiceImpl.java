package com.dt.hippo.my.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dt.hippo.auto.business.service.mapping.DishspecificationinfoServiceMapper;
import com.dt.hippo.auto.business.service.mapping.VouchergeneratorinfoServiceMapper;
import com.dt.hippo.auto.data.repository.jpa.StoreinfoJpaRepository;
import com.dt.hippo.auto.model.Category;
import com.dt.hippo.auto.model.Comboinfo;
import com.dt.hippo.auto.model.Dishinfo;
import com.dt.hippo.auto.model.Dishspecificationinfo;
import com.dt.hippo.auto.model.Promotiondetailinfo;
import com.dt.hippo.auto.model.Promotioninfo;
import com.dt.hippo.auto.model.Vouchergeneratorinfo;
import com.dt.hippo.auto.model.jpa.CategoryEntity;
import com.dt.hippo.auto.model.jpa.DishinfoEntity;
import com.dt.hippo.auto.model.jpa.DishpriceEntity;
import com.dt.hippo.auto.model.jpa.DishspecificationinfoEntity;
import com.dt.hippo.auto.model.jpa.PromotioninfoEntity;
import com.dt.hippo.auto.model.jpa.StoreinfoEntity;
import com.dt.hippo.auto.model.jpa.VouchergeneratorinfoEntity;
import com.dt.hippo.business.base.SuperService;
import com.dt.hippo.business.model.PromotionMangerBean;
import com.dt.hippo.business.model.com.DishCom;
import com.dt.hippo.business.model.com.StoreInfo;
import com.dt.hippo.my.repository.CstCategoryJpaRepository;
import com.dt.hippo.my.repository.CstPromotioninfoJpaRepository;
import com.dt.hippo.my.repository.CstVouchergeneratorinfoJpaRepository;
import com.dt.hippo.my.service.CstBusinessService;
import com.dt.hippo.my.service.CstOrderService;


@Service
@Transactional
public class CstBusinessServiceImpl extends SuperService implements CstBusinessService
{
    @Resource
    private CstCategoryJpaRepository cstCategoryJpaRepository;

    @Resource
    private CstPromotioninfoJpaRepository cstPromotioninfoJpaRepository;

    @Resource
    private CstVouchergeneratorinfoJpaRepository cstVouchergeneratorinfoJpaRepository;

    @Resource
    protected StoreinfoJpaRepository storeinfoJpaRepository;

    @Resource
    protected DishspecificationinfoServiceMapper dishspecificationinfoServiceMapper;

    @Resource
    protected VouchergeneratorinfoServiceMapper vouchergeneratorinfoServiceMapper;

    @Resource
    protected CstOrderService cstOrderService;

    @Transactional(readOnly = true)
    public StoreInfo getStoreInfo(Long storeId)
    {
        StoreInfo storeInfo = new StoreInfo(storeId);

        StoreinfoEntity storeinfoEntity = storeinfoJpaRepository.findOne(storeId);
        if (storeinfoEntity == null)
        {
            throw new RuntimeException("can't find the store with ID:" + storeId);
        }
        storeInfo.setCorpid(storeInfo.getCorpid());
        List<CategoryEntity> categoryList = cstCategoryJpaRepository
                .findByCorpidAndStatus(storeinfoEntity.getCorpid(), 0);

        List<PromotioninfoEntity> promotionList = cstPromotioninfoJpaRepository
                .findPromotionForStore(storeinfoEntity.getType(),
                        storeinfoEntity.getCorpid(), storeId);
        PromotionMangerBean promotionManager = createPromotionMangerBean(promotionList);
        List<Category> beans = new ArrayList<Category>();
        Map<Long, Dishspecificationinfo> bufferForAllDishes = new HashMap<Long, Dishspecificationinfo>();
        List<Dishinfo> comboAll = new ArrayList<Dishinfo>();

        List<Dishinfo> newDishList = new ArrayList<Dishinfo>();
        List<Dishinfo> newAddedDishList = new ArrayList<Dishinfo>();
        // Date currentDate = utils.getCurrentDate();
        for (CategoryEntity category : categoryList)
        {
            if (!this.isValidBean(category))
            {
                continue;
            }
            // category.setListOfDishinfo(this
            // .filterStatus(category.getListOfDishinfo()));
            // remove the dishes which are waiting to be approved or temporarily
            // paused
            // or it is not for sale
            // category.setListOfDishinfo(Lists
            // .newArrayList(Collections2.filter(
            // category.getListOfDishinfo(),
            // new Predicate<DishinfoEntity>()
            // {
            //
            // @Override
            // public boolean apply(
            // DishinfoEntity input)
            // {
            // return (input.getStatus() == null || input
            // .getStatus().equals(
            // 0))
            // && input.getPaused() == 0 && input.getNotforsale() == 0;
            // }
            // })));
            List<DishinfoEntity> dishList = category.getListOfDishinfo();

            // prevent the convertion
            category.setListOfDishinfo(null);
            Category categoryBean = modelMapper.map(category, Category.class);

            beans.add(categoryBean);
            if (categoryBean.getType() == 1)
            {
                categoryBean.setNewAddedDishList(newAddedDishList);
            }

            categoryBean.setListOfDishinfo(newDishList);
            for (DishinfoEntity dish : dishList)
            {
                if (!this.isValidBean(dish))
                {
                    continue;
                }
                if (dish.getPaused() == 0 && dish.getNotforsale() == 0)
                {
                    // for each dish, we remove the specifications which are not
                    // approved
                    List<Dishspecificationinfo> listOfDishspecificationinfo = new ArrayList<Dishspecificationinfo>();
                    List<DishspecificationinfoEntity> oldListOfDishspecificationinfo = dish
                            .getListOfDishspecificationinfo();
                    //
                    dish.setListOfDishspecificationinfo(null);
                    Dishspecificationinfo defaultDishspecificationinfoBean = null;
                    for (DishspecificationinfoEntity dishspecificationinfoEntity : oldListOfDishspecificationinfo)
                    {
                        if (!this.isValidBean(dish))
                        {
                            continue;
                        }
                        // get Valid price list
                        // dishspecificationinfoEntity
                        // .setListOfDishprice();
                        List<DishpriceEntity> listOfDishprice = dishspecificationinfoEntity
                                .getListOfDishprice();
                        DishpriceEntity mostImportantPriceEntity = null;

                        for (DishpriceEntity priceEntity : listOfDishprice)
                        {
                            if (!this.isValidBean(priceEntity))
                            {
                                continue;
                            }
                            // 0，全体定价
                            if (priceEntity.getStoretype() == 0)
                            {
                                if (priceEntity.getTargetvalue() == 0)
                                {
                                    if (mostImportantPriceEntity == null)
                                    {
                                        mostImportantPriceEntity = priceEntity;
                                    }
                                }
                                else
                                {
                                    if (priceEntity.getTargetvalue().equals(
                                            storeinfoEntity.getType()))
                                    {
                                        mostImportantPriceEntity = priceEntity;
                                    }
                                }

                            }
                            else
                            {
                                // 1，精确到门店的价格
                                if (priceEntity.getTargetvalue().equals(
                                        storeinfoEntity.getUid()))
                                {
                                    mostImportantPriceEntity = priceEntity;
                                    break;
                                }
                            }

                        }
                        // it get price successfully
                        if (mostImportantPriceEntity != null)
                        {
                            dishspecificationinfoEntity.setListOfDishprice(Arrays
                                    .asList(mostImportantPriceEntity));
                            // if(dish.getType() == 1)
                            // {
                            // List<ComboinfoEntity comboinfoEntity =
                            // dishspecificationinfoEntity.getListOfComboinfo();
                            // }
                            // 作为套餐，有可能会获取到很多层级，不要管他
                            Dishspecificationinfo dishspecificationinfoBean = dishspecificationinfoServiceMapper
                                    .mapDishspecificationinfoEntityToDishspecificationinfo(dishspecificationinfoEntity);
                            // Buffer the dish, for the combo setting
                            bufferForAllDishes.put(dishspecificationinfoBean.getUid(),
                                    dishspecificationinfoBean);

                            // 设定默认价格
                            dishspecificationinfoBean
                                    .setCurrentPrice(mostImportantPriceEntity);
                            dishspecificationinfoBean.setCombo(dish.getType() == 1);
                            dishspecificationinfoBean.setPrice(mostImportantPriceEntity
                                    .getPrice());
                            dishspecificationinfoBean
                                    .setRealprice(mostImportantPriceEntity.getPrice());
                            if (dishspecificationinfoBean.getName() == null)
                            {
                                dishspecificationinfoBean.setName(dish.getDishname());
                            }
                            if (dishspecificationinfoBean.getDishdescription() == null)
                            {
                                dishspecificationinfoBean.setDishdescription(dish
                                        .getDishdescription());
                            }
                            if (dishspecificationinfoBean.getImageurl() == null)
                            {
                                dishspecificationinfoBean.setImageurl(dish
                                        .getImageurl());
                            }

                            if (dishspecificationinfoBean.isCombo())
                            {
                                // to create default set for combo
                                Collections.sort(
                                        dishspecificationinfoBean.getListOfComboinfo(),
                                        new Comparator<Comboinfo>()
                                        {

                                            @Override
                                            public int compare(Comboinfo o1,
                                                    Comboinfo o2)
                                            {
                                                return o1.getPlaceholder() == o2
                                                        .getPlaceholder() ? o1
                                                        .getOrderinplaceholder()
                                                        - o2.getOrderinplaceholder()
                                                        : o1.getPlaceholder()
                                                                - o2.getPlaceholder();
                                            }
                                        });
                                List<Comboinfo> defaultComboSet = new ArrayList<Comboinfo>();
                                Comboinfo lastComboinfo = null;
                                for (Comboinfo comboinfo : dishspecificationinfoBean
                                        .getListOfComboinfo())
                                {
                                    if (lastComboinfo == null
                                            || lastComboinfo.getPlaceholder() != comboinfo
                                                    .getPlaceholder())
                                    {
                                        defaultComboSet.add(comboinfo);
                                        lastComboinfo = comboinfo;
                                    }
                                    comboinfo.setRealPricedifference(comboinfo
                                            .getPricedifference());

                                }
                                // set the combo set
                                dishspecificationinfoBean
                                        .setDefaultComboSet(defaultComboSet);

                            }
                            // 作为一个有效的规格，放入到餐列表
                            listOfDishspecificationinfo.add(dishspecificationinfoBean);
                            // 获取默认的规格，用来显示到列表
                            if (dishspecificationinfoEntity.getGgno() == null
                                    || dishspecificationinfoEntity.getGgno().equals(
                                            dish.getDefaultggno()))
                            {
                                defaultDishspecificationinfoBean = dishspecificationinfoBean;
                            }

                            // 促销信息
                            Promotioninfo promotioninfo = promotionManager
                                    .getPromotioninfo(category.getCategoryid(),
                                            dishspecificationinfoBean.getUid());
                            if (promotioninfo != null)
                            {
                                dishspecificationinfoBean
                                        .setPromotioninfo(promotioninfo);
                                // 0：群体促销 1：标准类型
                                if (promotioninfo.getType() == 0)
                                {
                                    long realPrice = calculatePriceWithDiscount(
                                            dishspecificationinfoBean.getPrice(),
                                            promotioninfo.getDiscount());
                                    dishspecificationinfoBean.setRealprice(realPrice);
                                }
                                else
                                {
                                    for (Promotiondetailinfo promotiondetailinfo : promotioninfo
                                            .getListOfPromotiondetailinfo())
                                    {
                                        if (promotiondetailinfo.getSpecificationid()
                                                .equals(dishspecificationinfoBean
                                                        .getUid()))
                                        {
                                            dishspecificationinfoBean
                                                    .setPromotiondetailinfo(promotiondetailinfo);
                                            // TODO Combo set
                                            // 0:折后价格，1:折扣率。套餐只能用折扣
                                            if (promotiondetailinfo.getType() == 0)
                                            {
                                                dishspecificationinfoBean
                                                        .setRealprice(promotiondetailinfo
                                                                .getPriceordiscount());
                                            }
                                            else
                                            {
                                                dishspecificationinfoBean
                                                        .setRealprice(calculatePriceWithDiscount(
                                                                dishspecificationinfoBean
                                                                        .getRealprice(),
                                                                promotiondetailinfo
                                                                        .getPriceordiscount()));
                                                if (dishspecificationinfoBean.isCombo())
                                                {
                                                    for (Comboinfo comboinfo : dishspecificationinfoBean
                                                            .getListOfComboinfo())
                                                    {
                                                        comboinfo
                                                                .setRealPricedifference(calculatePriceWithDiscount(
                                                                        comboinfo
                                                                                .getPricedifference(),
                                                                        promotiondetailinfo
                                                                                .getPriceordiscount()));
                                                    }
                                                }
                                            }
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                        // }
                    }
                    // if there is any specification for the Dish, we show it
                    if (listOfDishspecificationinfo.size() > 0)
                    {
                        // 如果当前没有默认，则获取第一个作为默认
                        if (defaultDishspecificationinfoBean == null)
                        {
                            defaultDishspecificationinfoBean = listOfDishspecificationinfo
                                    .get(0);
                        }
                        Dishinfo dishinfoBean = modelMapper.map(dish, Dishinfo.class);
                        // if the dish is combo
                        if (dishinfoBean.getType() == 1)
                        {
                            comboAll.add(dishinfoBean);
                            // TODO build the default combo
                        }
                        if (dishinfoBean.getNewstatusenddate() != null
                                && this.isStrictValidEndate(dishinfoBean
                                        .getNewstatusenddate()))
                        {
                            dishinfoBean.setNewDish(true);
                            newAddedDishList.add(dishinfoBean);
                        }
                        dishinfoBean
                                .setDefaultDishspecificationinfo(defaultDishspecificationinfoBean);
                        dishinfoBean
                                .setListOfDishspecificationinfo(listOfDishspecificationinfo);

                        newDishList.add(dishinfoBean);
                    }
                }

            }

        }
        for (Dishinfo dishinfoBean : comboAll)
        {
            for (Comboinfo comboinfo : dishinfoBean.getDefaultDishspecificationinfo()
                    .getListOfComboinfo())
            {
                // if it is main dish
                if (comboinfo.getPlaceholder() == 0)
                {
                    Dishspecificationinfo mainDish = bufferForAllDishes.get(comboinfo
                            .getSpecificationid());
                    if (mainDish != null)
                    {
                        mainDish.setAttachedCombo(dishinfoBean);
                    }
                }
            }
        }
        storeInfo.setCategoryList(beans);

        // voucher generator info
        List<VouchergeneratorinfoEntity> voucherGeneratorEntityList = cstVouchergeneratorinfoJpaRepository
                .findVouchergeneratorinfoForStore(storeinfoEntity.getType(),
                        storeinfoEntity.getCorpid(), storeId,
                        this.utils.getCurrentDate());
        List<Vouchergeneratorinfo> voucherGeneratorList = new ArrayList<Vouchergeneratorinfo>();
        for (VouchergeneratorinfoEntity vouchergeneratorinfoEntity : voucherGeneratorEntityList)
        {
            vouchergeneratorinfoEntity.setListOfLottoryvoucherinfo(null);
            if (!this.isValidBean(vouchergeneratorinfoEntity))
            {
                continue;
            }
            Vouchergeneratorinfo voucherGerneratorInfo = vouchergeneratorinfoServiceMapper
                    .mapVouchergeneratorinfoEntityToVouchergeneratorinfo(vouchergeneratorinfoEntity);
            voucherGeneratorList.add(voucherGerneratorInfo);
        }
        storeInfo.setVoucherGeneratorList(voucherGeneratorList);

        return storeInfo;

    }

    public PromotionMangerBean createPromotionMangerBean(
            List<PromotioninfoEntity> promotionList)
    {
        PromotionMangerBean bean = new PromotionMangerBean();
        Collections.sort(promotionList, new Comparator<PromotioninfoEntity>()
        {

            @Override
            public int compare(PromotioninfoEntity o1, PromotioninfoEntity o2)
            {
                return o1.getModifydate().compareTo(o2.getModifydate());
            }
        });
        for (PromotioninfoEntity promotion : promotionList)
        {
            // promotion.get
            bean.register(this.modelMapper.map(promotion, Promotioninfo.class));
        }
        bean.finished();
        return bean;

    }

    @Override
    public DishCom getStoreinfoForUser(Long storeid, Long userid)
    {
        DishCom dishCom = new DishCom();
        dishCom.setStoreInfo(this.getStoreInfo(storeid));
        if (userid != null)
        {
            dishCom.setHistoryOrderList(cstOrderService.getPastOrders(storeid, userid,
                    200L));
        }
        return dishCom;
    }

    @Override
    public DishCom getStoreinfoForUser(Long storeid)
    {

        return this.getStoreinfoForUser(storeid,
                this.getCurrentLoginUser() != null ? this.getCurrentLoginUser()
                        .getDelegateUser().getUid() : null);

    }
}
