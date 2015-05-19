/*
 * Created on 18 五月 2015 ( Time 17:57:12 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.auto.model.base;

import java.io.Serializable;

import javax.validation.constraints.*;

import java.util.Date;

public class Vouchergeneratorinfo extends com.dt.hippo.core.base.BaseBeanCommon implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    protected Integer uid;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    

    protected Integer corpid;

    @NotNull
    protected Integer type;


    protected Long objecttosend;


    protected Date deliverystartdate;


    protected Date deliveryenddate;


    protected Integer deliverystarttime;


    protected Integer deliveryendtime;


    protected Date applystartdate;


    protected Date applyenddate;


    protected Integer limitationmethod;

    @Size( max = 10 )
    protected String timezone;


    protected Integer maxamount;


    protected Integer maxamountperperson;

    @NotNull
    protected Integer applytoallstore;

    @NotNull
    protected Integer applytoalldish;


    protected Integer overlayuse;


    protected Integer value;


    protected Date createdate;


    protected Date modifydate;

    @Size( max = 50 )
    protected String createuser;

    @Size( max = 50 )
    protected String modifyuser;


    protected Integer status;

    @Size( max = 50 )
    protected String platform;



    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setUid( Integer uid ) {
        this.uid = uid ;
    }

    public Integer getUid() {
        return this.uid;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    public void setCorpid( Integer corpid ) {
        this.corpid = corpid;
    }
    public Integer getCorpid() {
        return this.corpid;
    }

    public void setType( Integer type ) {
        this.type = type;
    }
    public Integer getType() {
        return this.type;
    }

    public void setObjecttosend( Long objecttosend ) {
        this.objecttosend = objecttosend;
    }
    public Long getObjecttosend() {
        return this.objecttosend;
    }

    public void setDeliverystartdate( Date deliverystartdate ) {
        this.deliverystartdate = deliverystartdate;
    }
    public Date getDeliverystartdate() {
        return this.deliverystartdate;
    }

    public void setDeliveryenddate( Date deliveryenddate ) {
        this.deliveryenddate = deliveryenddate;
    }
    public Date getDeliveryenddate() {
        return this.deliveryenddate;
    }

    public void setDeliverystarttime( Integer deliverystarttime ) {
        this.deliverystarttime = deliverystarttime;
    }
    public Integer getDeliverystarttime() {
        return this.deliverystarttime;
    }

    public void setDeliveryendtime( Integer deliveryendtime ) {
        this.deliveryendtime = deliveryendtime;
    }
    public Integer getDeliveryendtime() {
        return this.deliveryendtime;
    }

    public void setApplystartdate( Date applystartdate ) {
        this.applystartdate = applystartdate;
    }
    public Date getApplystartdate() {
        return this.applystartdate;
    }

    public void setApplyenddate( Date applyenddate ) {
        this.applyenddate = applyenddate;
    }
    public Date getApplyenddate() {
        return this.applyenddate;
    }

    public void setLimitationmethod( Integer limitationmethod ) {
        this.limitationmethod = limitationmethod;
    }
    public Integer getLimitationmethod() {
        return this.limitationmethod;
    }

    public void setTimezone( String timezone ) {
        this.timezone = timezone;
    }
    public String getTimezone() {
        return this.timezone;
    }

    public void setMaxamount( Integer maxamount ) {
        this.maxamount = maxamount;
    }
    public Integer getMaxamount() {
        return this.maxamount;
    }

    public void setMaxamountperperson( Integer maxamountperperson ) {
        this.maxamountperperson = maxamountperperson;
    }
    public Integer getMaxamountperperson() {
        return this.maxamountperperson;
    }

    public void setApplytoallstore( Integer applytoallstore ) {
        this.applytoallstore = applytoallstore;
    }
    public Integer getApplytoallstore() {
        return this.applytoallstore;
    }

    public void setApplytoalldish( Integer applytoalldish ) {
        this.applytoalldish = applytoalldish;
    }
    public Integer getApplytoalldish() {
        return this.applytoalldish;
    }

    public void setOverlayuse( Integer overlayuse ) {
        this.overlayuse = overlayuse;
    }
    public Integer getOverlayuse() {
        return this.overlayuse;
    }

    public void setValue( Integer value ) {
        this.value = value;
    }
    public Integer getValue() {
        return this.value;
    }

    public void setCreatedate( Date createdate ) {
        this.createdate = createdate;
    }
    public Date getCreatedate() {
        return this.createdate;
    }

    public void setModifydate( Date modifydate ) {
        this.modifydate = modifydate;
    }
    public Date getModifydate() {
        return this.modifydate;
    }

    public void setCreateuser( String createuser ) {
        this.createuser = createuser;
    }
    public String getCreateuser() {
        return this.createuser;
    }

    public void setModifyuser( String modifyuser ) {
        this.modifyuser = modifyuser;
    }
    public String getModifyuser() {
        return this.modifyuser;
    }

    public void setStatus( Integer status ) {
        this.status = status;
    }
    public Integer getStatus() {
        return this.status;
    }

    public void setPlatform( String platform ) {
        this.platform = platform;
    }
    public String getPlatform() {
        return this.platform;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
 
        public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(uid);
        sb.append("|");
        sb.append(corpid);
        sb.append("|");
        sb.append(type);
        sb.append("|");
        sb.append(objecttosend);
        sb.append("|");
        sb.append(deliverystartdate);
        sb.append("|");
        sb.append(deliveryenddate);
        sb.append("|");
        sb.append(deliverystarttime);
        sb.append("|");
        sb.append(deliveryendtime);
        sb.append("|");
        sb.append(applystartdate);
        sb.append("|");
        sb.append(applyenddate);
        sb.append("|");
        sb.append(limitationmethod);
        sb.append("|");
        sb.append(timezone);
        sb.append("|");
        sb.append(maxamount);
        sb.append("|");
        sb.append(maxamountperperson);
        sb.append("|");
        sb.append(applytoallstore);
        sb.append("|");
        sb.append(applytoalldish);
        sb.append("|");
        sb.append(overlayuse);
        sb.append("|");
        sb.append(value);
        sb.append("|");
        sb.append(createdate);
        sb.append("|");
        sb.append(modifydate);
        sb.append("|");
        sb.append(createuser);
        sb.append("|");
        sb.append(modifyuser);
        sb.append("|");
        sb.append(status);
        sb.append("|");
        sb.append(platform);
        return sb.toString(); 
    } 


}
