/*
 * Created on 16 五月 2015 ( Time 16:13:12 )
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
public class PaymentlogEntity implements Serializable {

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
    @Column(name="userId")
    protected Long       userid       ;

    @Column(name="projectId")
    protected Long       projectid    ;

    @Column(name="tradeNo", length=100)
    protected String     tradeno      ;

    @Column(name="orderNo", length=50)
    protected String     orderno      ;

    @Column(name="operation", length=200)
    protected String     operation    ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="tradeDate")
    protected Date       tradedate    ;

    @Column(name="useragent", length=500)
    protected String     useragent    ;

    @Column(name="ip", length=100)
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
    public PaymentlogEntity() {
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
    //--- DATABASE MAPPING : userId ( BIGINT ) 
    public void setUserid( Long userid ) {
        this.userid = userid;
    }
    public Long getUserid() {
        return this.userid;
    }

    //--- DATABASE MAPPING : projectId ( BIGINT ) 
    public void setProjectid( Long projectid ) {
        this.projectid = projectid;
    }
    public Long getProjectid() {
        return this.projectid;
    }

    //--- DATABASE MAPPING : tradeNo ( VARCHAR ) 
    public void setTradeno( String tradeno ) {
        this.tradeno = tradeno;
    }
    public String getTradeno() {
        return this.tradeno;
    }

    //--- DATABASE MAPPING : orderNo ( VARCHAR ) 
    public void setOrderno( String orderno ) {
        this.orderno = orderno;
    }
    public String getOrderno() {
        return this.orderno;
    }

    //--- DATABASE MAPPING : operation ( VARCHAR ) 
    public void setOperation( String operation ) {
        this.operation = operation;
    }
    public String getOperation() {
        return this.operation;
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
        sb.append(userid);
        sb.append("|");
        sb.append(projectid);
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
