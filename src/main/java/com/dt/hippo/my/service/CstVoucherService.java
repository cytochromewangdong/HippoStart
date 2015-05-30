/*
 * Copyright (c) 2015 NeuLion, Inc. All Rights Reserved.
 */
package com.dt.hippo.my.service;

import com.dt.hippo.auto.model.Uservoucher;

public interface CstVoucherService
{
    public Uservoucher obtainVourcher(long userId, long voucherId);

}
