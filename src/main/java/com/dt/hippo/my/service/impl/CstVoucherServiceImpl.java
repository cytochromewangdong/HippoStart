/*
 * Copyright (c) 2015 NeuLion, Inc. All Rights Reserved.
 */
package com.dt.hippo.my.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dt.hippo.auto.business.service.mapping.UservoucherServiceMapper;
import com.dt.hippo.auto.model.Uservoucher;
import com.dt.hippo.auto.model.jpa.LottoryvoucherinfoEntity;
import com.dt.hippo.auto.model.jpa.UservoucherEntity;
import com.dt.hippo.auto.model.jpa.VouchergeneratorinfoEntity;
import com.dt.hippo.business.base.SuperService;
import com.dt.hippo.my.repository.CstUservoucherJpaRepository;
import com.dt.hippo.my.repository.CstVouchergeneratorinfoJpaRepository;
import com.dt.hippo.my.service.CstVoucherService;


@Service
@Transactional
public class CstVoucherServiceImpl extends SuperService implements CstVoucherService
{
    @Resource
    protected CstVouchergeneratorinfoJpaRepository cstVouchergeneratorinfoJpaRepository;

    @Resource
    protected CstUservoucherJpaRepository cstUservoucherJpaRepository;

    @Resource
    protected UservoucherServiceMapper uservoucherServiceMapper;

    @Override
    public Uservoucher obtainVourcher(long userId, long voucherId)
    {
        VouchergeneratorinfoEntity vouchergeneratorinfoEntity = cstVouchergeneratorinfoJpaRepository
                .findOne(voucherId);
        if (vouchergeneratorinfoEntity == null
                || !this.isValidBeanWithStatus(vouchergeneratorinfoEntity))
        {
            return null;
        }

        // TODO make sure whether version represent the amount of vouchers that
        // has been generated
        if (vouchergeneratorinfoEntity.getMaxamount() <= vouchergeneratorinfoEntity
                .getVersion())
        {
            return null;
        }
        // TODO consider timezone
        if (!this.isStrictValidDateRange(
                vouchergeneratorinfoEntity.getDeliverystartdate(),
                vouchergeneratorinfoEntity.getDeliveryenddate())
                || !this.isStrictValidTimeRange(
                        vouchergeneratorinfoEntity.getDeliverystarttime(),
                        vouchergeneratorinfoEntity.getDeliveryendtime()))
        {
            return null;
        }
        List<UservoucherEntity> ownedVoucherList = cstUservoucherJpaRepository
                .findByOwneridAndVoucherid(userId, voucherId);
        // 0：每天限制次数，1：限制总次数
        if (ownedVoucherList != null)
        {
            if (vouchergeneratorinfoEntity.getLimitationmethod() == 0)
            {
                int todayObtainedAmount = 0;
                for (UservoucherEntity uservoucherEntity : ownedVoucherList)
                {
                    if (this.isToday(uservoucherEntity.getCreatedate()))
                    {
                        todayObtainedAmount++;
                    }
                }
                if (todayObtainedAmount >= vouchergeneratorinfoEntity
                        .getMaxamountperperson())
                {
                    return null;
                }
            }
            else
            {
                if (ownedVoucherList.size() >= vouchergeneratorinfoEntity
                        .getMaxamountperperson())
                {
                    return null;
                }
            }
        }
        UservoucherEntity uservoucherEntity = new UservoucherEntity();
        uservoucherEntity.setOwnerid(userId);
        // TODO to make corpid with the same type in the two entity
        uservoucherEntity.setCorpid(vouchergeneratorinfoEntity.getCorpid());
        // uservoucherEntity.setVersion(0);
        uservoucherEntity.setVoucherid(voucherId);
        // uservoucherEntity.setVoucherdetailid(null);
        uservoucherEntity.setObjecttosend(vouchergeneratorinfoEntity.getObjecttosend());
        uservoucherEntity.setApplystartdate(vouchergeneratorinfoEntity
                .getApplystartdate());
        uservoucherEntity.setApplytoalldish(vouchergeneratorinfoEntity
                .getApplytoalldish());
        uservoucherEntity.setApplytoallstore(vouchergeneratorinfoEntity
                .getApplytoallstore());
        uservoucherEntity.setOverlayuse(vouchergeneratorinfoEntity.getOverlayuse());
        uservoucherEntity.setStatus(1);
        // uservoucherEntity.setPlatform(platform);

        // type--0：固定，1：彩票
        if (vouchergeneratorinfoEntity.getObjecttosend() == 0
                || vouchergeneratorinfoEntity.getType() == 0)
        {
            // uservoucherEntity.setValue(vouchergeneratorinfoEntity.getValue());
        }
        else
        {
            List<LottoryvoucherinfoEntity> listOfLottoryvoucherinfo = vouchergeneratorinfoEntity
                    .getListOfLottoryvoucherinfo();
            //TODO get lottory voucher value
        }

        // TODO update vouchergeneratorinfoEntity

        cstUservoucherJpaRepository.save(uservoucherEntity);

        return uservoucherServiceMapper
                .mapUservoucherEntityToUservoucher(uservoucherEntity);
    }

}
