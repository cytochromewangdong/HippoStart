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
 * Persistent class for entity stored in table "paymentlog"
 *
 * @author Telosys Tools Generator
 *
 */
@MappedSuperclass
//@Entity
@Table(name="paymentlog", catalog="hippo" )
// Define named queries here
//@NamedQueries ( {
//  @NamedQuery ( name="PaymentlogEntity.countAll", query="SELECT COUNT(x) FROM PaymentlogEntity x" )
//} )
public class PaymentlogEntity extends com.dt.hippo.core.base.BaseBeanCommon implements Serializable {

    protected static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    protected Long       uid          ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    protected Long       userid       ;

    protected String     tradeno      ;

    protected String     orderno      ;

    protected String     operation    ;

    protected Date       tradedate    ;

    protected String     useragent    ;

    protected String     ip           ;

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
    public PaymentlogEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setUid( Long uid ) {
        this.uid = uid ;
    }
       @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
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

    //--- DATABASE MAPPING : operation ( VARCHAR ) 
    public void setOperation( String operation ) {
        this.operation = operation;
    }
       @Column(name="operation", length=200)
 public String getOperation() {
        return this.operation;
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

    //--- DATABASE MAPPING : ip ( VARCHAR ) 
    public void setIp( String ip ) {
        this.ip = ip;
    }
       @Column(name="ip", length=100)
 public String getIp() {
        return this.ip;
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
