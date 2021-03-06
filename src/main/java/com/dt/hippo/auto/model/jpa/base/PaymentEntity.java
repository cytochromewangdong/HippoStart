/*
 * Created on 27 五月 2015 ( Time 17:36:24 )
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
 * Persistent class for entity stored in table "payment"
 *
 * @author Telosys Tools Generator
 *
 */
@MappedSuperclass
//@Entity
@Table(name="payment", catalog="hippo" )
// Define named queries here
//@NamedQueries ( {
//  @NamedQuery ( name="PaymentEntity.countAll", query="SELECT COUNT(x) FROM PaymentEntity x" )
//} )
public class PaymentEntity extends com.dt.hippo.core.base.BaseBeanCommon implements Serializable {

    protected static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    protected Long       uid          ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    protected Long       userid       ;

    protected Long       corpid       ;

    protected Long       storeid      ;

    protected String     tradeno      ;

    protected String     orderno      ;

    protected String     ordercurrency ;

    protected String     orderamount  ;

    protected Integer    orderstatus  ;

    protected String     orderinfo    ;

    protected String     riskinfo     ;

    protected Integer    paymentmethod ;

    protected Integer    ismobile     ;

    protected Date       tradedate    ;

    protected String     useragent    ;

    protected String     rawreponsefrompaygate ;

    protected Integer    paytype      ;

    protected Date       createdate   ;

    protected Date       modifydate   ;

    protected String     createuser   ;

    protected String     modifyuser   ;

    protected Byte       delflg       ;

    protected String     platform     ;



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public PaymentEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setUid( Long uid ) {
        this.uid = uid ;
    }
       @Id
    @Column(name="uid", nullable=false)
  public Long getUid() {
        return this.uid;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : userId ( BIGINT ) 
    public void setUserid( Long userid ) {
        this.userid = userid;
    }
       @Column(name="userId")
 public Long getUserid() {
        return this.userid;
    }

    //--- DATABASE MAPPING : corpId ( BIGINT ) 
    public void setCorpid( Long corpid ) {
        this.corpid = corpid;
    }
       @Column(name="corpId")
 public Long getCorpid() {
        return this.corpid;
    }

    //--- DATABASE MAPPING : storeID ( BIGINT ) 
    public void setStoreid( Long storeid ) {
        this.storeid = storeid;
    }
       @Column(name="storeID")
 public Long getStoreid() {
        return this.storeid;
    }

    //--- DATABASE MAPPING : tradeNo ( VARCHAR ) 
    public void setTradeno( String tradeno ) {
        this.tradeno = tradeno;
    }
       @Column(name="tradeNo", length=100)
 public String getTradeno() {
        return this.tradeno;
    }

    //--- DATABASE MAPPING : orderNo ( VARCHAR ) 
    public void setOrderno( String orderno ) {
        this.orderno = orderno;
    }
       @Column(name="orderNo", length=50)
 public String getOrderno() {
        return this.orderno;
    }

    //--- DATABASE MAPPING : orderCurrency ( VARCHAR ) 
    public void setOrdercurrency( String ordercurrency ) {
        this.ordercurrency = ordercurrency;
    }
       @Column(name="orderCurrency", length=3)
 public String getOrdercurrency() {
        return this.ordercurrency;
    }

    //--- DATABASE MAPPING : orderAmount ( VARCHAR ) 
    public void setOrderamount( String orderamount ) {
        this.orderamount = orderamount;
    }
       @Column(name="orderAmount", length=10)
 public String getOrderamount() {
        return this.orderamount;
    }

    //--- DATABASE MAPPING : orderStatus ( INT ) 
    public void setOrderstatus( Integer orderstatus ) {
        this.orderstatus = orderstatus;
    }
       @Column(name="orderStatus")
 public Integer getOrderstatus() {
        return this.orderstatus;
    }

    //--- DATABASE MAPPING : orderInfo ( VARCHAR ) 
    public void setOrderinfo( String orderinfo ) {
        this.orderinfo = orderinfo;
    }
       @Column(name="orderInfo", length=500)
 public String getOrderinfo() {
        return this.orderinfo;
    }

    //--- DATABASE MAPPING : riskInfo ( VARCHAR ) 
    public void setRiskinfo( String riskinfo ) {
        this.riskinfo = riskinfo;
    }
       @Column(name="riskInfo", length=1000)
 public String getRiskinfo() {
        return this.riskinfo;
    }

    //--- DATABASE MAPPING : paymentMethod ( INT ) 
    public void setPaymentmethod( Integer paymentmethod ) {
        this.paymentmethod = paymentmethod;
    }
       @Column(name="paymentMethod")
 public Integer getPaymentmethod() {
        return this.paymentmethod;
    }

    //--- DATABASE MAPPING : isMobile ( INT ) 
    public void setIsmobile( Integer ismobile ) {
        this.ismobile = ismobile;
    }
       @Column(name="isMobile")
 public Integer getIsmobile() {
        return this.ismobile;
    }

    //--- DATABASE MAPPING : tradeDate ( DATETIME ) 
    public void setTradedate( Date tradedate ) {
        this.tradedate = tradedate;
    }
       @Temporal(TemporalType.TIMESTAMP)
    @Column(name="tradeDate")
 public Date getTradedate() {
        return this.tradedate;
    }

    //--- DATABASE MAPPING : useragent ( VARCHAR ) 
    public void setUseragent( String useragent ) {
        this.useragent = useragent;
    }
       @Column(name="useragent", length=500)
 public String getUseragent() {
        return this.useragent;
    }

    //--- DATABASE MAPPING : rawReponseFromPaygate ( VARCHAR ) 
    public void setRawreponsefrompaygate( String rawreponsefrompaygate ) {
        this.rawreponsefrompaygate = rawreponsefrompaygate;
    }
       @Column(name="rawReponseFromPaygate", length=1000)
 public String getRawreponsefrompaygate() {
        return this.rawreponsefrompaygate;
    }

    //--- DATABASE MAPPING : payType ( INT ) 
    public void setPaytype( Integer paytype ) {
        this.paytype = paytype;
    }
       @Column(name="payType")
 public Integer getPaytype() {
        return this.paytype;
    }

    //--- DATABASE MAPPING : createDate ( DATETIME ) 
    public void setCreatedate( Date createdate ) {
        this.createdate = createdate;
    }
       @Temporal(TemporalType.TIMESTAMP)
    @Column(name="createDate")
 public Date getCreatedate() {
        return this.createdate;
    }

    //--- DATABASE MAPPING : modifyDate ( DATETIME ) 
    public void setModifydate( Date modifydate ) {
        this.modifydate = modifydate;
    }
       @Temporal(TemporalType.TIMESTAMP)
    @Column(name="modifyDate")
 public Date getModifydate() {
        return this.modifydate;
    }

    //--- DATABASE MAPPING : createUser ( VARCHAR ) 
    public void setCreateuser( String createuser ) {
        this.createuser = createuser;
    }
       @Column(name="createUser", length=50)
 public String getCreateuser() {
        return this.createuser;
    }

    //--- DATABASE MAPPING : modifyUser ( VARCHAR ) 
    public void setModifyuser( String modifyuser ) {
        this.modifyuser = modifyuser;
    }
       @Column(name="modifyUser", length=50)
 public String getModifyuser() {
        return this.modifyuser;
    }

    //--- DATABASE MAPPING : delFlg ( TINYINT ) 
    public void setDelflg( Byte delflg ) {
        this.delflg = delflg;
    }
       @Column(name="delFlg")
 public Byte getDelflg() {
        return this.delflg;
    }

    //--- DATABASE MAPPING : platform ( VARCHAR ) 
    public void setPlatform( String platform ) {
        this.platform = platform;
    }
       @Column(name="platform", length=50)
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
        sb.append(userid);
        sb.append("|");
        sb.append(corpid);
        sb.append("|");
        sb.append(storeid);
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
        sb.append(paytype);
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
