/*
 * Copyright (c) 2015 NeuLion, Inc. All Rights Reserved.
 */
package com.dt.hippo.auto.model.jpa;

import java.io.Serializable;

import javax.persistence.AttributeOverrides;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="lottoryVoucherInfo", catalog="hippo" )
@AttributeOverrides({

})
public class LottoryvoucherinfoEntity extends
        com.dt.hippo.auto.model.jpa.base.LottoryvoucherinfoEntity implements
        Serializable
{

    /** serialVersionUID */
    private static final long serialVersionUID = -6163228592810582860L;
    
    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    protected VouchergeneratorinfoEntity vouchergeneratorinfo;



    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    
    @ManyToOne
    @JoinColumn(name="parentVoucherID", referencedColumnName="uid", insertable = false, updatable = false)
    public VouchergeneratorinfoEntity getVouchergeneratorinfo()
    {
        return vouchergeneratorinfo;
    }

    public void setVouchergeneratorinfo(VouchergeneratorinfoEntity vouchergeneratorinfo)
    {
        this.vouchergeneratorinfo = vouchergeneratorinfo;
    }

}
