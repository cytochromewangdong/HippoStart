/*
 * Created on 13 五月 2015 ( Time 21:15:24 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
// This Bean has a composite Primary Key  


package com.dt.hippo.auto.model.jpa.base;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.util.Date;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "comboinfo"
 *
 * @author Telosys Tools Generator
 *
 */
@MappedSuperclass
//@Entity
@Table(name="comboinfo", catalog="hippo" )
// Define named queries here
//@NamedQueries ( {
//  @NamedQuery ( name="ComboinfoEntity.countAll", query="SELECT COUNT(x) FROM ComboinfoEntity x" )
//} )
public class ComboinfoEntity implements Serializable {

    protected static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( EMBEDDED IN AN EXTERNAL CLASS )  
    //----------------------------------------------------------------------
	@EmbeddedId
    protected ComboinfoEntityKey compositePrimaryKey ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="placeholder")
    protected Byte       placeholder  ;

    @Column(name="orderInPlaceholder")
    protected Byte       orderinplaceholder ;

    @Column(name="amount")
    protected Integer    amount       ;

    @Column(name="priceDifference")
    protected Double     pricedifference ;

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
    public ComboinfoEntity() {
		super();
		this.compositePrimaryKey = new ComboinfoEntityKey();       
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
    public void setChildid( Long childid ) {
        this.compositePrimaryKey.setChildid( childid ) ;
    }
    public Long getChildid() {
        return this.compositePrimaryKey.getChildid() ;
    }
    public void setSpecificationid( Long specificationid ) {
        this.compositePrimaryKey.setSpecificationid( specificationid ) ;
    }
    public Long getSpecificationid() {
        return this.compositePrimaryKey.getSpecificationid() ;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : placeholder ( TINYINT ) 
    public void setPlaceholder( Byte placeholder ) {
        this.placeholder = placeholder;
    }
    public Byte getPlaceholder() {
        return this.placeholder;
    }

    //--- DATABASE MAPPING : orderInPlaceholder ( TINYINT ) 
    public void setOrderinplaceholder( Byte orderinplaceholder ) {
        this.orderinplaceholder = orderinplaceholder;
    }
    public Byte getOrderinplaceholder() {
        return this.orderinplaceholder;
    }

    //--- DATABASE MAPPING : amount ( INT ) 
    public void setAmount( Integer amount ) {
        this.amount = amount;
    }
    public Integer getAmount() {
        return this.amount;
    }

    //--- DATABASE MAPPING : priceDifference ( DOUBLE ) 
    public void setPricedifference( Double pricedifference ) {
        this.pricedifference = pricedifference;
    }
    public Double getPricedifference() {
        return this.pricedifference;
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
        if ( compositePrimaryKey != null ) {  
            sb.append(compositePrimaryKey.toString());  
        }  
        else {  
            sb.append( "(null-key)" ); 
        }  
        sb.append("]:"); 
        sb.append(placeholder);
        sb.append("|");
        sb.append(orderinplaceholder);
        sb.append("|");
        sb.append(amount);
        sb.append("|");
        sb.append(pricedifference);
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