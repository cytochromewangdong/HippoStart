/*
 * Created on 18 五月 2015 ( Time 17:57:11 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.dt.hippo.auto.model.jpa.base;

import java.io.Serializable;


//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "dishSpecificationInfo"
 *
 * @author Telosys Tools Generator
 *
 */
@MappedSuperclass
//@Entity
@Table(name="dishSpecificationInfo", catalog="hippo" )
// Define named queries here
//@NamedQueries ( {
//  @NamedQuery ( name="DishspecificationinfoEntity.countAll", query="SELECT COUNT(x) FROM DishspecificationinfoEntity x" )
//} )
public class DishspecificationinfoEntity extends com.dt.hippo.core.base.BaseBeanCommon implements Serializable {

    protected static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name="uid", nullable=false)
    protected Long       uid          ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="dishId")
    protected Long       dishid       ;

    @Column(name="ggno", length=10)
    protected String     ggno         ;

    @Column(name="name", length=50)
    protected String     name         ;

    @Column(name="corpId", nullable=false)
    protected Long       corpid       ;

    @Column(name="dishName", length=200)
    protected String     dishname     ;

    @Column(name="dishDescription", length=300)
    protected String     dishdescription ;

    @Column(name="imageUrl", length=300)
    protected String     imageurl     ;

    @Column(name="price", nullable=false)
    protected Long       price        ;

    @Column(name="orderIndex")
    protected Integer    orderindex   ;

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

	// "dishid" (column "dishId") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public DishspecificationinfoEntity() {
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
    //--- DATABASE MAPPING : dishId ( BIGINT ) 
    public void setDishid( Long dishid ) {
        this.dishid = dishid;
    }
    public Long getDishid() {
        return this.dishid;
    }

    //--- DATABASE MAPPING : ggno ( VARCHAR ) 
    public void setGgno( String ggno ) {
        this.ggno = ggno;
    }
    public String getGgno() {
        return this.ggno;
    }

    //--- DATABASE MAPPING : name ( VARCHAR ) 
    public void setName( String name ) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    //--- DATABASE MAPPING : corpId ( BIGINT ) 
    public void setCorpid( Long corpid ) {
        this.corpid = corpid;
    }
    public Long getCorpid() {
        return this.corpid;
    }

    //--- DATABASE MAPPING : dishName ( VARCHAR ) 
    public void setDishname( String dishname ) {
        this.dishname = dishname;
    }
    public String getDishname() {
        return this.dishname;
    }

    //--- DATABASE MAPPING : dishDescription ( VARCHAR ) 
    public void setDishdescription( String dishdescription ) {
        this.dishdescription = dishdescription;
    }
    public String getDishdescription() {
        return this.dishdescription;
    }

    //--- DATABASE MAPPING : imageUrl ( VARCHAR ) 
    public void setImageurl( String imageurl ) {
        this.imageurl = imageurl;
    }
    public String getImageurl() {
        return this.imageurl;
    }

    //--- DATABASE MAPPING : price ( BIGINT ) 
    public void setPrice( Long price ) {
        this.price = price;
    }
    public Long getPrice() {
        return this.price;
    }

    //--- DATABASE MAPPING : orderIndex ( INT ) 
    public void setOrderindex( Integer orderindex ) {
        this.orderindex = orderindex;
    }
    public Integer getOrderindex() {
        return this.orderindex;
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
        sb.append(uid);
        sb.append("]:"); 
        sb.append(dishid);
        sb.append("|");
        sb.append(ggno);
        sb.append("|");
        sb.append(name);
        sb.append("|");
        sb.append(corpid);
        sb.append("|");
        sb.append(dishname);
        sb.append("|");
        sb.append(dishdescription);
        sb.append("|");
        sb.append(imageurl);
        sb.append("|");
        sb.append(price);
        sb.append("|");
        sb.append(orderindex);
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
