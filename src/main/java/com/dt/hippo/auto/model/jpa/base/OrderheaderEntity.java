/*
 * Created on 18 五月 2015 ( Time 17:57:11 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.dt.hippo.auto.model.jpa.base;

import java.io.Serializable;


//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.util.Date;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "orderheader"
 *
 * @author Telosys Tools Generator
 *
 */
@MappedSuperclass
//@Entity
@Table(name="orderheader", catalog="hippo" )
// Define named queries here
//@NamedQueries ( {
//  @NamedQuery ( name="OrderheaderEntity.countAll", query="SELECT COUNT(x) FROM OrderheaderEntity x" )
//} )
public class OrderheaderEntity extends com.dt.hippo.core.base.BaseBeanCommon implements Serializable {

    protected static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name="uid", nullable=false)
    protected Long       uid          ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="orderNo", length=50)
    protected String     orderno      ;

    @Column(name="parentOrderNo", length=50)
    protected String     parentorderno ;

    @Column(name="paymentNo", length=50)
    protected String     paymentno    ;

    @Column(name="payAcount")
    protected Long       payacount    ;

    @Column(name="acount")
    protected Long       acount       ;

    @Column(name="orderStatus")
    protected Integer    orderstatus  ;

    @Column(name="orderInfo", length=500)
    protected String     orderinfo    ;

    @Column(name="paymentMethod")
    protected Integer    paymentmethod ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="tradeDate")
    protected Date       tradedate    ;

    @Column(name="useragent", length=500)
    protected String     useragent    ;

    @Column(name="userId")
    protected Long       userid       ;

    @Column(name="storeId")
    protected Long       storeid      ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="delieverTime")
    protected Date       delievertime ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="cancelTime")
    protected Date       canceltime   ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="confirmTime")
    protected Date       confirmtime  ;

    @Column(name="ip", length=20)
    protected String     ip           ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="createDate")
    protected Date       createdate   ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="modifyDate")
    protected Date       modifydate   ;

    @Column(name="createUser", length=50)
    protected String     createuser   ;

    @Column(name="modifyUser", length=50)
    protected String     modifyuser   ;

    @Column(name="status")
    protected Integer    status       ;

    @Column(name="platform", length=50)
    protected String     platform     ;



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public OrderheaderEntity() {
		super();
    }
    
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
    //--- DATABASE MAPPING : orderNo ( VARCHAR ) 
    public void setOrderno( String orderno ) {
        this.orderno = orderno;
    }
    public String getOrderno() {
        return this.orderno;
    }

    //--- DATABASE MAPPING : parentOrderNo ( VARCHAR ) 
    public void setParentorderno( String parentorderno ) {
        this.parentorderno = parentorderno;
    }
    public String getParentorderno() {
        return this.parentorderno;
    }

    //--- DATABASE MAPPING : paymentNo ( VARCHAR ) 
    public void setPaymentno( String paymentno ) {
        this.paymentno = paymentno;
    }
    public String getPaymentno() {
        return this.paymentno;
    }

    //--- DATABASE MAPPING : payAcount ( BIGINT ) 
    public void setPayacount( Long payacount ) {
        this.payacount = payacount;
    }
    public Long getPayacount() {
        return this.payacount;
    }

    //--- DATABASE MAPPING : acount ( BIGINT ) 
    public void setAcount( Long acount ) {
        this.acount = acount;
    }
    public Long getAcount() {
        return this.acount;
    }

    //--- DATABASE MAPPING : orderStatus ( INT ) 
    public void setOrderstatus( Integer orderstatus ) {
        this.orderstatus = orderstatus;
    }
    public Integer getOrderstatus() {
        return this.orderstatus;
    }

    //--- DATABASE MAPPING : orderInfo ( VARCHAR ) 
    public void setOrderinfo( String orderinfo ) {
        this.orderinfo = orderinfo;
    }
    public String getOrderinfo() {
        return this.orderinfo;
    }

    //--- DATABASE MAPPING : paymentMethod ( INT ) 
    public void setPaymentmethod( Integer paymentmethod ) {
        this.paymentmethod = paymentmethod;
    }
    public Integer getPaymentmethod() {
        return this.paymentmethod;
    }

    //--- DATABASE MAPPING : tradeDate ( DATETIME ) 
    public void setTradedate( Date tradedate ) {
        this.tradedate = tradedate;
    }
    public Date getTradedate() {
        return this.tradedate;
    }

    //--- DATABASE MAPPING : useragent ( VARCHAR ) 
    public void setUseragent( String useragent ) {
        this.useragent = useragent;
    }
    public String getUseragent() {
        return this.useragent;
    }

    //--- DATABASE MAPPING : userId ( BIGINT ) 
    public void setUserid( Long userid ) {
        this.userid = userid;
    }
    public Long getUserid() {
        return this.userid;
    }

    //--- DATABASE MAPPING : storeId ( BIGINT ) 
    public void setStoreid( Long storeid ) {
        this.storeid = storeid;
    }
    public Long getStoreid() {
        return this.storeid;
    }

    //--- DATABASE MAPPING : delieverTime ( DATETIME ) 
    public void setDelievertime( Date delievertime ) {
        this.delievertime = delievertime;
    }
    public Date getDelievertime() {
        return this.delievertime;
    }

    //--- DATABASE MAPPING : cancelTime ( DATETIME ) 
    public void setCanceltime( Date canceltime ) {
        this.canceltime = canceltime;
    }
    public Date getCanceltime() {
        return this.canceltime;
    }

    //--- DATABASE MAPPING : confirmTime ( DATETIME ) 
    public void setConfirmtime( Date confirmtime ) {
        this.confirmtime = confirmtime;
    }
    public Date getConfirmtime() {
        return this.confirmtime;
    }

    //--- DATABASE MAPPING : ip ( VARCHAR ) 
    public void setIp( String ip ) {
        this.ip = ip;
    }
    public String getIp() {
        return this.ip;
    }

    //--- DATABASE MAPPING : createDate ( DATETIME ) 
    public void setCreatedate( Date createdate ) {
        this.createdate = createdate;
    }
    public Date getCreatedate() {
        return this.createdate;
    }

    //--- DATABASE MAPPING : modifyDate ( DATETIME ) 
    public void setModifydate( Date modifydate ) {
        this.modifydate = modifydate;
    }
    public Date getModifydate() {
        return this.modifydate;
    }

    //--- DATABASE MAPPING : createUser ( VARCHAR ) 
    public void setCreateuser( String createuser ) {
        this.createuser = createuser;
    }
    public String getCreateuser() {
        return this.createuser;
    }

    //--- DATABASE MAPPING : modifyUser ( VARCHAR ) 
    public void setModifyuser( String modifyuser ) {
        this.modifyuser = modifyuser;
    }
    public String getModifyuser() {
        return this.modifyuser;
    }

    //--- DATABASE MAPPING : status ( INT ) 
    public void setStatus( Integer status ) {
        this.status = status;
    }
    public Integer getStatus() {
        return this.status;
    }

    //--- DATABASE MAPPING : platform ( VARCHAR ) 
    public void setPlatform( String platform ) {
        this.platform = platform;
    }
    public String getPlatform() {
        return this.platform;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(uid);
        sb.append("]:"); 
        sb.append(orderno);
        sb.append("|");
        sb.append(parentorderno);
        sb.append("|");
        sb.append(paymentno);
        sb.append("|");
        sb.append(payacount);
        sb.append("|");
        sb.append(acount);
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
        sb.append(delievertime);
        sb.append("|");
        sb.append(canceltime);
        sb.append("|");
        sb.append(confirmtime);
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
        sb.append(status);
        sb.append("|");
        sb.append(platform);
        return sb.toString(); 
    } 

}
