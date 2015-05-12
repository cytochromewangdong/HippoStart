/*
 * Created on 12 五月 2015 ( Time 20:53:04 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.dt.hippo.auto.model.jpa;

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

@Entity
@Table(name="orderheader", catalog="hippo" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="OrderheaderEntity.countAll", query="SELECT COUNT(x) FROM OrderheaderEntity x" )
} )
public class OrderheaderEntity implements Serializable {

    protected static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
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
    protected Double     payacount    ;

    @Column(name="totalAcount")
    protected Double     totalacount  ;

    @Column(name="discount")
    protected Double     discount     ;

    @Column(name="discountId", length=50)
    protected String     discountid   ;

    @Column(name="orderStatus")
    protected Byte       orderstatus  ;

    @Column(name="orderInfo", length=500)
    protected String     orderinfo    ;

    @Column(name="paymentMethod")
    protected Byte       paymentmethod ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="tradeDate")
    protected Date       tradedate    ;

    @Column(name="useragent", length=500)
    protected String     useragent    ;

    @Column(name="userId")
    protected Long       userid       ;

    @Column(name="storeId")
    protected Long       storeid      ;

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

    @Column(name="delFlg")
    protected Byte       delflg       ;

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

    //--- DATABASE MAPPING : payAcount ( DOUBLE ) 
    public void setPayacount( Double payacount ) {
        this.payacount = payacount;
    }
    public Double getPayacount() {
        return this.payacount;
    }

    //--- DATABASE MAPPING : totalAcount ( DOUBLE ) 
    public void setTotalacount( Double totalacount ) {
        this.totalacount = totalacount;
    }
    public Double getTotalacount() {
        return this.totalacount;
    }

    //--- DATABASE MAPPING : discount ( DOUBLE ) 
    public void setDiscount( Double discount ) {
        this.discount = discount;
    }
    public Double getDiscount() {
        return this.discount;
    }

    //--- DATABASE MAPPING : discountId ( VARCHAR ) 
    public void setDiscountid( String discountid ) {
        this.discountid = discountid;
    }
    public String getDiscountid() {
        return this.discountid;
    }

    //--- DATABASE MAPPING : orderStatus ( TINYINT ) 
    public void setOrderstatus( Byte orderstatus ) {
        this.orderstatus = orderstatus;
    }
    public Byte getOrderstatus() {
        return this.orderstatus;
    }

    //--- DATABASE MAPPING : orderInfo ( VARCHAR ) 
    public void setOrderinfo( String orderinfo ) {
        this.orderinfo = orderinfo;
    }
    public String getOrderinfo() {
        return this.orderinfo;
    }

    //--- DATABASE MAPPING : paymentMethod ( TINYINT ) 
    public void setPaymentmethod( Byte paymentmethod ) {
        this.paymentmethod = paymentmethod;
    }
    public Byte getPaymentmethod() {
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

    //--- DATABASE MAPPING : delFlg ( TINYINT ) 
    public void setDelflg( Byte delflg ) {
        this.delflg = delflg;
    }
    public Byte getDelflg() {
        return this.delflg;
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
