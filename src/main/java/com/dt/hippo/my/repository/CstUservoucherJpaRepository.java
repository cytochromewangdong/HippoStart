/*
 * Copyright (c) 2015 NeuLion, Inc. All Rights Reserved.
 */
package com.dt.hippo.my.repository;

import java.util.List;

import com.dt.hippo.auto.model.jpa.UservoucherEntity;
import com.dt.hippo.business.common.CommonRepository;


public interface CstUservoucherJpaRepository extends
        CommonRepository<UservoucherEntity, Long>
{
    List<UservoucherEntity> findByOwneridAndVoucherid(long ownerId, long voucherId);

}
