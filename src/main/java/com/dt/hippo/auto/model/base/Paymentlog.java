/*
 * Created on 18 五月 2015 ( Time 17:57:11 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.auto.model.base;

import java.io.Serializable;

import javax.validation.constraints.*;

import java.util.Date;

public class Paymentlog extends com.dt.hippo.core.base.BaseBeanCommon implements Serializable {

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

    @Size( max = 100 )
    protected String tradeno;

    @Size( max = 50 )
    protected String orderno;

    @Size( max = 200 )
    protected String operation;


    protected Date tradedate;

    @Size( max = 500 )
    protected String useragent;

    @Size( max = 100 )
    protected String ip;


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

    public void setOperation( String operation ) {
        this.operation = operation;
    }
    public String getOperation() {
        return this.operation;
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

    public void setIp( String ip ) {
        this.ip = ip;
    }
    public String getIp() {
        return this.ip;
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
        sb.append(tradeno);
        sb.append("|");
        sb.append(orderno);
        sb.append("|");
        sb.append(operation);
        sb.append("|");
        sb.append(tradedate);
        sb.append("|");
        sb.append(useragent);
        sb.append("|");
        sb.append(ip);
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
