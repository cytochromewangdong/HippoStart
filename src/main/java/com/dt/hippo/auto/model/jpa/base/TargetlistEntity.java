/*
 * Created on 18 五月 2015 ( Time 17:57:12 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
// This Bean has a composite Primary Key  

package com.dt.hippo.auto.model.jpa.base;

import java.io.Serializable;

import com.dt.hippo.auto.model.jpa.TargetlistEntityKey;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.util.Date;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "targetList"
 *
 * @author Telosys Tools Generator
 *
 */
@MappedSuperclass
//@Entity
@Table(name="targetList", catalog="hippo" )
// Define named queries here
//@NamedQueries ( {
//  @NamedQuery ( name="TargetlistEntity.countAll", query="SELECT COUNT(x) FROM TargetlistEntity x" )
//} )
public class TargetlistEntity extends com.dt.hippo.core.base.BaseBeanCommon implements Serializable {

    protected static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( EMBEDDED IN AN EXTERNAL CLASS )  
    //----------------------------------------------------------------------
	@EmbeddedId
    protected TargetlistEntityKey compositePrimaryKey ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
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
    public TargetlistEntity() {
		super();
		this.compositePrimaryKey = new TargetlistEntityKey();       
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE COMPOSITE KEY 
    //----------------------------------------------------------------------
    public void setUid( Long uid ) {
        this.compositePrimaryKey.setUid( uid ) ;
    }
    public Long getUid() {
        return this.compositePrimaryKey.getUid() ;
    }
    public void setType( Integer type ) {
        this.compositePrimaryKey.setType( type ) ;
    }
    public Integer getType() {
        return this.compositePrimaryKey.getType() ;
    }
    public void setCorpid( Long corpid ) {
        this.compositePrimaryKey.setCorpid( corpid ) ;
    }
    public Long getCorpid() {
        return this.compositePrimaryKey.getCorpid() ;
    }
    public void setTargetvalue( Long targetvalue ) {
        this.compositePrimaryKey.setTargetvalue( targetvalue ) ;
    }
    public Long getTargetvalue() {
        return this.compositePrimaryKey.getTargetvalue() ;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
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
        if ( compositePrimaryKey != null ) {  
            sb.append(compositePrimaryKey.toString());  
        }  
        else {  
            sb.append( "(null-key)" ); 
        }  
        sb.append("]:"); 
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