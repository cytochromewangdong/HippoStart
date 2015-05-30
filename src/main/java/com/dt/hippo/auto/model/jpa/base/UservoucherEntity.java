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
 * Persistent class for entity stored in table "userVoucher"
 *
 * @author Telosys Tools Generator
 *
 */
@MappedSuperclass
//@Entity
@Table(name="userVoucher", catalog="hippo" )
// Define named queries here
//@NamedQueries ( {
//  @NamedQuery ( name="UservoucherEntity.countAll", query="SELECT COUNT(x) FROM UservoucherEntity x" )
//} )
public class UservoucherEntity extends com.dt.hippo.core.base.BaseBeanCommon implements Serializable {

    protected static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    protected Long       uid          ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    protected Long       ownerid      ;

    protected Long       voucherid    ;

    protected Long       voucherdetailid ;

    protected Long       value        ;

    protected Long       objecttosend ;

    protected Long       orderuid     ;

    protected Date       usedate      ;

    protected Date       applystartdate ;

    protected Date       applyenddate ;

    protected Integer    applytoallstore ;

    protected Integer    applytoalldish ;

    protected Integer    overlayuse   ;

    protected Date       createdate   ;

    protected Date       modifydate   ;

    protected String     createuser   ;

    protected String     modifyuser   ;

    protected Integer    status       ;

    protected String     platform     ;

    protected Integer    version      ;

    protected Long       corpid       ;



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public UservoucherEntity() {
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
    //--- DATABASE MAPPING : ownerId ( BIGINT ) 
    public void setOwnerid( Long ownerid ) {
        this.ownerid = ownerid;
    }
       @Column(name="ownerId")
 public Long getOwnerid() {
        return this.ownerid;
    }

    //--- DATABASE MAPPING : voucherId ( BIGINT ) 
    public void setVoucherid( Long voucherid ) {
        this.voucherid = voucherid;
    }
       @Column(name="voucherId")
 public Long getVoucherid() {
        return this.voucherid;
    }

    //--- DATABASE MAPPING : voucherDetailId ( BIGINT ) 
    public void setVoucherdetailid( Long voucherdetailid ) {
        this.voucherdetailid = voucherdetailid;
    }
       @Column(name="voucherDetailId")
 public Long getVoucherdetailid() {
        return this.voucherdetailid;
    }

    //--- DATABASE MAPPING : value ( BIGINT ) 
    public void setValue( Long value ) {
        this.value = value;
    }
       @Column(name="value")
 public Long getValue() {
        return this.value;
    }

    //--- DATABASE MAPPING : objectToSend ( BIGINT ) 
    public void setObjecttosend( Long objecttosend ) {
        this.objecttosend = objecttosend;
    }
       @Column(name="objectToSend")
 public Long getObjecttosend() {
        return this.objecttosend;
    }

    //--- DATABASE MAPPING : orderUid ( BIGINT ) 
    public void setOrderuid( Long orderuid ) {
        this.orderuid = orderuid;
    }
       @Column(name="orderUid")
 public Long getOrderuid() {
        return this.orderuid;
    }

    //--- DATABASE MAPPING : useDate ( DATETIME ) 
    public void setUsedate( Date usedate ) {
        this.usedate = usedate;
    }
       @Temporal(TemporalType.TIMESTAMP)
    @Column(name="useDate")
 public Date getUsedate() {
        return this.usedate;
    }

    //--- DATABASE MAPPING : applyStartDate ( DATE ) 
    public void setApplystartdate( Date applystartdate ) {
        this.applystartdate = applystartdate;
    }
       @Temporal(TemporalType.DATE)
    @Column(name="applyStartDate")
 public Date getApplystartdate() {
        return this.applystartdate;
    }

    //--- DATABASE MAPPING : applyEndDate ( DATE ) 
    public void setApplyenddate( Date applyenddate ) {
        this.applyenddate = applyenddate;
    }
       @Temporal(TemporalType.DATE)
    @Column(name="applyEndDate")
 public Date getApplyenddate() {
        return this.applyenddate;
    }

    //--- DATABASE MAPPING : applyToAllStore ( INT ) 
    public void setApplytoallstore( Integer applytoallstore ) {
        this.applytoallstore = applytoallstore;
    }
       @Column(name="applyToAllStore")
 public Integer getApplytoallstore() {
        return this.applytoallstore;
    }

    //--- DATABASE MAPPING : applyToAllDish ( INT ) 
    public void setApplytoalldish( Integer applytoalldish ) {
        this.applytoalldish = applytoalldish;
    }
       @Column(name="applyToAllDish")
 public Integer getApplytoalldish() {
        return this.applytoalldish;
    }

    //--- DATABASE MAPPING : overlayUse ( INT ) 
    public void setOverlayuse( Integer overlayuse ) {
        this.overlayuse = overlayuse;
    }
       @Column(name="overlayUse")
 public Integer getOverlayuse() {
        return this.overlayuse;
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

    //--- DATABASE MAPPING : status ( INT ) 
    public void setStatus( Integer status ) {
        this.status = status;
    }
       @Column(name="status")
 public Integer getStatus() {
        return this.status;
    }

    //--- DATABASE MAPPING : platform ( VARCHAR ) 
    public void setPlatform( String platform ) {
        this.platform = platform;
    }
       @Column(name="platform", length=50)
 public String getPlatform() {
        return this.platform;
    }

    //--- DATABASE MAPPING : version ( INT ) 
    public void setVersion( Integer version ) {
        this.version = version;
    }
       @Column(name="version")
   	@Version
 public Integer getVersion() {
        return this.version;
    }

    //--- DATABASE MAPPING : corpId ( BIGINT ) 
    public void setCorpid( Long corpid ) {
        this.corpid = corpid;
    }
       @Column(name="corpId")
 public Long getCorpid() {
        return this.corpid;
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
        sb.append(ownerid);
        sb.append("|");
        sb.append(voucherid);
        sb.append("|");
        sb.append(voucherdetailid);
        sb.append("|");
        sb.append(value);
        sb.append("|");
        sb.append(objecttosend);
        sb.append("|");
        sb.append(orderuid);
        sb.append("|");
        sb.append(usedate);
        sb.append("|");
        sb.append(applystartdate);
        sb.append("|");
        sb.append(applyenddate);
        sb.append("|");
        sb.append(applytoallstore);
        sb.append("|");
        sb.append(applytoalldish);
        sb.append("|");
        sb.append(overlayuse);
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
        sb.append("|");
        sb.append(version);
        sb.append("|");
        sb.append(corpid);
        return sb.toString(); 
    } 

}
