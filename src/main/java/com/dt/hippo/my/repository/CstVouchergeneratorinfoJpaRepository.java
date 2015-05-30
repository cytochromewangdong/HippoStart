/*
 * Copyright (c) 2015 NeuLion, Inc. All Rights Reserved.
 */
package com.dt.hippo.my.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dt.hippo.auto.model.jpa.VouchergeneratorinfoEntity;
import com.dt.hippo.business.common.CommonRepository;


public interface CstVouchergeneratorinfoJpaRepository extends
        CommonRepository<VouchergeneratorinfoEntity, Long>
{
    @Query("SELECT x FROM VouchergeneratorinfoEntity x where (corpid=:corpid) and ((targettype=0 and (applytoall = 0 or (applytoall=1 and :storetype IN (select s.targetvalue from TargetlistEntity s where s.uid = x.uid and type=1 and corpid=:corpid)))) or (targettype=1 and :storeid  IN (select s.targetvalue from TargetlistEntity s where s.uid = x.uid and type=1 and corpid=:corpid))) and (deliverystartdate<=:currentDate and deliveryenddate>=:currentDate)")
    List<VouchergeneratorinfoEntity> findVouchergeneratorinfoForStore(
            @Param("storetype") Integer storetype, @Param("corpid") Long corpid,
            @Param("storeid") Long storeid, @Param("currentDate") Date currentDate);

}
