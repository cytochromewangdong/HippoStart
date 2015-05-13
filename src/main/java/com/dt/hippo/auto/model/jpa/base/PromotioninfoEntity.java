/*
 * Created on 13 五月 2015 ( Time 21:15:30 )
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
 * Persistent class for entity stored in table "promotionInfo"
 *
 * @author Telosys Tools Generator
 *
 */
@MappedSuperclass
//@Entity
@Table(name="promotionInfo", catalog="hippo" )
// Define named queries here
//@NamedQueries ( {
//  @NamedQuery ( name="PromotioninfoEntity.countAll", query="SELECT COUNT(x) FROM PromotioninfoEntity x" )
//} )
public class PromotioninfoEntity implements Serializable {

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
    @Column(name="corpId")
    protected Long       corpid       ;

    @Column(name="name", length=50)
    protected String     name         ;

    @Column(name="description", length=300)
    protected String     description  ;

    @Column(name="imageUrl", length=300)
    protected String     imageurl     ;

    @Column(name="promotionTime")
    protected Integer    promotiontime ;

    @Column(name="promotionEndTime")
    protected Integer    promotionendtime ;

    @Column(name="isApplied")
    protected Byte       isapplied    ;

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
    public PromotioninfoEntity() {
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
    //--- DATABASE MAPPING : corpId ( BIGINT ) 
    public void setCorpid( Long corpid ) {
        this.corpid = corpid;
    }
    public Long getCorpid() {
        return this.corpid;
    }

    //--- DATABASE MAPPING : name ( VARCHAR ) 
    public void setName( String name ) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    //--- DATABASE MAPPING : description ( VARCHAR ) 
    public void setDescription( String description ) {
        this.description = description;
    }
    public String getDescription() {
        return this.description;
    }

    //--- DATABASE MAPPING : imageUrl ( VARCHAR ) 
    public void setImageurl( String imageurl ) {
        this.imageurl = imageurl;
    }
    public String getImageurl() {
        return this.imageurl;
    }

    //--- DATABASE MAPPING : promotionTime ( INT ) 
    public void setPromotiontime( Integer promotiontime ) {
        this.promotiontime = promotiontime;
    }
    public Integer getPromotiontime() {
        return this.promotiontime;
    }

    //--- DATABASE MAPPING : promotionEndTime ( INT ) 
    public void setPromotionendtime( Integer promotionendtime ) {
        this.promotionendtime = promotionendtime;
    }
    public Integer getPromotionendtime() {
        return this.promotionendtime;
    }

    //--- DATABASE MAPPING : isApplied ( TINYINT ) 
    public void setIsapplied( Byte isapplied ) {
        this.isapplied = isapplied;
    }
    public Byte getIsapplied() {
        return this.isapplied;
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
        sb.append(corpid);
        sb.append("|");
        sb.append(name);
        sb.append("|");
        sb.append(description);
        sb.append("|");
        sb.append(imageurl);
        sb.append("|");
        sb.append(promotiontime);
        sb.append("|");
        sb.append(promotionendtime);
        sb.append("|");
        sb.append(isapplied);
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
