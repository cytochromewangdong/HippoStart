/*
 * Created on 14 五月 2015 ( Time 21:11:36 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.auto.model.base;

import java.io.Serializable;

import javax.validation.constraints.*;

import java.util.Date;

public class Orderheader implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    protected Long uid;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Size( max = 50 )
    protected String orderno;

    @Size( max = 50 )
    protected String parentorderno;

    @Size( max = 50 )
    protected String paymentno;


    protected Double payacount;


    protected Double totalacount;


    protected Double discount;

    @Size( max = 50 )
    protected String discountid;


    protected Byte orderstatus;

    @Size( max = 500 )
    protected String orderinfo;


    protected Byte paymentmethod;


    protected Date tradedate;

    @Size( max = 500 )
    protected String useragent;


    protected Long userid;


    protected Long storeid;

    @Size( max = 20 )
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
    public void setOrderno( String orderno ) {
        this.orderno = orderno;
    }
    public String getOrderno() {
        return this.orderno;
    }

    public void setParentorderno( String parentorderno ) {
        this.parentorderno = parentorderno;
    }
    public String getParentorderno() {
        return this.parentorderno;
    }

    public void setPaymentno( String paymentno ) {
        this.paymentno = paymentno;
    }
    public String getPaymentno() {
        return this.paymentno;
    }

    public void setPayacount( Double payacount ) {
        this.payacount = payacount;
    }
    public Double getPayacount() {
        return this.payacount;
    }

    public void setTotalacount( Double totalacount ) {
        this.totalacount = totalacount;
    }
    public Double getTotalacount() {
        return this.totalacount;
    }

    public void setDiscount( Double discount ) {
        this.discount = discount;
    }
    public Double getDiscount() {
        return this.discount;
    }

    public void setDiscountid( String discountid ) {
        this.discountid = discountid;
    }
    public String getDiscountid() {
        return this.discountid;
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

    public void setPaymentmethod( Byte paymentmethod ) {
        this.paymentmethod = paymentmethod;
    }
    public Byte getPaymentmethod() {
        return this.paymentmethod;
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

    public void setUserid( Long userid ) {
        this.userid = userid;
    }
    public Long getUserid() {
        return this.userid;
    }

    public void setStoreid( Long storeid ) {
        this.storeid = storeid;
    }
    public Long getStoreid() {
        return this.storeid;
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
        sb.append(orderno);
        sb.append("|");
        sb.append(parentorderno);
        sb.append("|");
        sb.append(paymentno);
        sb.append("|");
        sb.append(payacount);
        sb.append("|");
        sb.append(totalacount);
        sb.append("|");
        sb.append(discount);
        sb.append("|");
        sb.append(discountid);
        sb.append("|");
        sb.append(orderstatus);
        sb.append("|");
        sb.append(orderinfo);
        sb.append("|");
        sb.append(paymentmethod);
        sb.append("|");
        sb.append(tradedate);
        sb.append("|");
        sb.append(useragent);
        sb.append("|");
        sb.append(userid);
        sb.append("|");
        sb.append(storeid);
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
