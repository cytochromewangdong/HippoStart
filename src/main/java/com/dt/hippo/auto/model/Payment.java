/*
 * Created on 13 五月 2015 ( Time 21:15:28 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.auto.model;

import java.io.Serializable;

import javax.validation.constraints.*;

import java.util.Date;

public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    protected Long uid;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    

    protected Long userid;


    protected Long projectid;

    @Size( max = 100 )
    protected String tradeno;

    @Size( max = 50 )
    protected String orderno;

    @Size( max = 3 )
    protected String ordercurrency;

    @Size( max = 10 )
    protected String orderamount;


    protected Byte orderstatus;

    @Size( max = 500 )
    protected String orderinfo;

    @Size( max = 1000 )
    protected String riskinfo;


    protected Byte paymentmethod;


    protected Byte ismobile;


    protected Date tradedate;

    @Size( max = 500 )
    protected String useragent;

    @Size( max = 1000 )
    protected String rawreponsefrompaygate;


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
    public void setUserid( Long userid ) {
        this.userid = userid;
    }
    public Long getUserid() {
        return this.userid;
    }

    public void setProjectid( Long projectid ) {
        this.projectid = projectid;
    }
    public Long getProjectid() {
        return this.projectid;
    }

    public void setTradeno( String tradeno ) {
        this.tradeno = tradeno;
    }
    public String getTradeno() {
        return this.tradeno;
    }

    public void setOrderno( String orderno ) {
        this.orderno = orderno;
    }
    public String getOrderno() {
        return this.orderno;
    }

    public void setOrdercurrency( String ordercurrency ) {
        this.ordercurrency = ordercurrency;
    }
    public String getOrdercurrency() {
        return this.ordercurrency;
    }

    public void setOrderamount( String orderamount ) {
        this.orderamount = orderamount;
    }
    public String getOrderamount() {
        return this.orderamount;
    }

    public void setOrderstatus( Byte orderstatus ) {
        this.orderstatus = orderstatus;
    }
    public Byte getOrderstatus() {
        return this.orderstatus;
    }

    public void setOrderinfo( String orderinfo ) {
        this.orderinfo = orderinfo;
    }
    public String getOrderinfo() {
        return this.orderinfo;
    }

    public void setRiskinfo( String riskinfo ) {
        this.riskinfo = riskinfo;
    }
    public String getRiskinfo() {
        return this.riskinfo;
    }

    public void setPaymentmethod( Byte paymentmethod ) {
        this.paymentmethod = paymentmethod;
    }
    public Byte getPaymentmethod() {
        return this.paymentmethod;
    }

    public void setIsmobile( Byte ismobile ) {
        this.ismobile = ismobile;
    }
    public Byte getIsmobile() {
        return this.ismobile;
    }

    public void setTradedate( Date tradedate ) {
        this.tradedate = tradedate;
    }
    public Date getTradedate() {
        return this.tradedate;
    }

    public void setUseragent( String useragent ) {
        this.useragent = useragent;
    }
    public String getUseragent() {
        return this.useragent;
    }

    public void setRawreponsefrompaygate( String rawreponsefrompaygate ) {
        this.rawreponsefrompaygate = rawreponsefrompaygate;
    }
    public String getRawreponsefrompaygate() {
        return this.rawreponsefrompaygate;
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
        sb.append(userid);
        sb.append("|");
        sb.append(projectid);
        sb.append("|");
        sb.append(tradeno);
        sb.append("|");
        sb.append(orderno);
        sb.append("|");
        sb.append(ordercurrency);
        sb.append("|");
        sb.append(orderamount);
        sb.append("|");
        sb.append(orderstatus);
        sb.append("|");
        sb.append(orderinfo);
        sb.append("|");
        sb.append(riskinfo);
        sb.append("|");
        sb.append(paymentmethod);
        sb.append("|");
        sb.append(ismobile);
        sb.append("|");
        sb.append(tradedate);
        sb.append("|");
        sb.append(useragent);
        sb.append("|");
        sb.append(rawreponsefrompaygate);
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
