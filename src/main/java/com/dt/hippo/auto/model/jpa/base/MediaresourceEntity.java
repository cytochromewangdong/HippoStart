/*
 * Created on 13 五月 2015 ( Time 21:15:26 )
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
 * Persistent class for entity stored in table "mediaresource"
 *
 * @author Telosys Tools Generator
 *
 */
@MappedSuperclass
//@Entity
@Table(name="mediaresource", catalog="hippo" )
// Define named queries here
//@NamedQueries ( {
//  @NamedQuery ( name="MediaresourceEntity.countAll", query="SELECT COUNT(x) FROM MediaresourceEntity x" )
//} )
public class MediaresourceEntity implements Serializable {

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
    @Column(name="type")
    protected Byte       type         ;

    @Column(name="userId")
    protected Long       userid       ;

    @Column(name="savePath", length=200)
    protected String     savepath     ;

    @Column(name="url", length=200)
    protected String     url          ;

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
    public MediaresourceEntity() {
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
    //--- DATABASE MAPPING : type ( TINYINT ) 
    public void setType( Byte type ) {
        this.type = type;
    }
    public Byte getType() {
        return this.type;
    }

    //--- DATABASE MAPPING : userId ( BIGINT ) 
    public void setUserid( Long userid ) {
        this.userid = userid;
    }
    public Long getUserid() {
        return this.userid;
    }

    //--- DATABASE MAPPING : savePath ( VARCHAR ) 
    public void setSavepath( String savepath ) {
        this.savepath = savepath;
    }
    public String getSavepath() {
        return this.savepath;
    }

    //--- DATABASE MAPPING : url ( VARCHAR ) 
    public void setUrl( String url ) {
        this.url = url;
    }
    public String getUrl() {
        return this.url;
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
        sb.append(type);
        sb.append("|");
        sb.append(userid);
        sb.append("|");
        sb.append(savepath);
        sb.append("|");
        sb.append(url);
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
