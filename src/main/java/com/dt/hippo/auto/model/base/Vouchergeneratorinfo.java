/*
 * Created on 16 五月 2015 ( Time 16:12:44 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.auto.model.base;

import java.io.Serializable;

import javax.validation.constraints.*;

import java.util.Date;

public class Vouchergeneratorinfo implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    protected Long uid;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    

    protected Long corpid;


    protected Integer type;


    protected Integer deliverystartdate;


    protected Integer deliveryenddate;


    protected Integer deliverystarttime;


    protected Integer deliveryendtime;


    protected Integer applystartdate;


    protected Integer applyenddate;


    protected Byte limitationmethod;

    @Size( max = 10 )
    protected String timezone;


    protected Integer maxamount;


    protected Integer maxamountperperson;


    protected Integer value;


    protected Date createdate;


    protected Date modifydate;

    @Size( max = 50 )
    protected String createuser;

    @Size( max = 50 )
    protected String modifyuser;


    protected Byte delflg;

    @Size( max = 50 )
    protected String platform;



    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setUid( Long uid ) {
        this.uid = uid ;
    }

    public Long getUid() {
        return this.uid;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    public void setCorpid( Long corpid ) {
        this.corpid = corpid;
    }
    public Long getCorpid() {
        return this.corpid;
    }

    public void setType( Integer type ) {
        this.type = type;
    }
    public Integer getType() {
        return this.type;
    }

    public void setDeliverystartdate( Integer deliverystartdate ) {
        this.deliverystartdate = deliverystartdate;
    }
    public Integer getDeliverystartdate() {
        return this.deliverystartdate;
    }

    public void setDeliveryenddate( Integer deliveryenddate ) {
        this.deliveryenddate = deliveryenddate;
    }
    public Integer getDeliveryenddate() {
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

    public void setApplystartdate( Integer applystartdate ) {
        this.applystartdate = applystartdate;
    }
    public Integer getApplystartdate() {
        return this.applystartdate;
    }

    public void setApplyenddate( Integer applyenddate ) {
        this.applyenddate = applyenddate;
    }
    public Integer getApplyenddate() {
        return this.applyenddate;
    }

    public void setLimitationmethod( Byte limitationmethod ) {
        this.limitationmethod = limitationmethod;
    }
    public Byte getLimitationmethod() {
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

    public void setDelflg( Byte delflg ) {
        this.delflg = delflg;
    }
    public Byte getDelflg() {
        return this.delflg;
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
        sb.append(delflg);
        sb.append("|");
        sb.append(platform);
        return sb.toString(); 
    } 


}
