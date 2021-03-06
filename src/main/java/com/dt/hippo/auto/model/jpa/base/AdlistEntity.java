/*
 * Created on 30 五月 2015 ( Time 18:22:34 )
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
 * Persistent class for entity stored in table "ADList"
 *
 * @author Telosys Tools Generator
 *
 */
@MappedSuperclass
//@Entity
@Table(name="ADList", catalog="hippo" )
// Define named queries here
//@NamedQueries ( {
//  @NamedQuery ( name="AdlistEntity.countAll", query="SELECT COUNT(x) FROM AdlistEntity x" )
//} )
public class AdlistEntity extends com.dt.hippo.core.base.BaseBeanCommon implements Serializable {

    protected static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    protected Long       uid          ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    protected Long       dishid       ;

    protected Long       corpid       ;

    protected Date       startdate    ;

    protected Date       enddate      ;

    protected Date       createdate   ;

    protected Date       modifydate   ;

    protected String     createuser   ;

    protected String     modifyuser   ;

    protected Integer    status       ;

    protected String     platform     ;



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public AdlistEntity() {
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
    //--- DATABASE MAPPING : dishId ( BIGINT ) 
    public void setDishid( Long dishid ) {
        this.dishid = dishid;
    }
       @Column(name="dishId")
 public Long getDishid() {
        return this.dishid;
    }

    //--- DATABASE MAPPING : corpId ( BIGINT ) 
    public void setCorpid( Long corpid ) {
        this.corpid = corpid;
    }
       @Column(name="corpId")
 public Long getCorpid() {
        return this.corpid;
    }

    //--- DATABASE MAPPING : startDate ( DATE ) 
    public void setStartdate( Date startdate ) {
        this.startdate = startdate;
    }
       @Temporal(TemporalType.DATE)
    @Column(name="startDate")
 public Date getStartdate() {
        return this.startdate;
    }

    //--- DATABASE MAPPING : endDate ( DATE ) 
    public void setEnddate( Date enddate ) {
        this.enddate = enddate;
    }
       @Temporal(TemporalType.DATE)
    @Column(name="endDate")
 public Date getEnddate() {
        return this.enddate;
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
        sb.append(dishid);
        sb.append("|");
        sb.append(corpid);
        sb.append("|");
        sb.append(startdate);
        sb.append("|");
        sb.append(enddate);
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
