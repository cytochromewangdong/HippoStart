/*
 * Created on 13 五月 2015 ( Time 21:15:32 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.dt.hippo.auto.model.jpa.base;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;


import javax.persistence.*;

/**
 * Persistent class for entity stored in table "systemparameter"
 *
 * @author Telosys Tools Generator
 *
 */
@MappedSuperclass
//@Entity
@Table(name="systemparameter", catalog="hippo" )
// Define named queries here
//@NamedQueries ( {
//  @NamedQuery ( name="SystemparameterEntity.countAll", query="SELECT COUNT(x) FROM SystemparameterEntity x" )
//} )
public class SystemparameterEntity implements Serializable {

    protected static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="uid", nullable=false)
    protected Integer    uid          ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="keyword", length=30)
    protected String     keyword      ;

    @Column(name="value", length=100)
    protected String     value        ;

    @Column(name="property")
    protected Byte       property     ;



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public SystemparameterEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setUid( Integer uid ) {
        this.uid = uid ;
    }
    public Integer getUid() {
        return this.uid;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : keyword ( VARCHAR ) 
    public void setKeyword( String keyword ) {
        this.keyword = keyword;
    }
    public String getKeyword() {
        return this.keyword;
    }

    //--- DATABASE MAPPING : value ( VARCHAR ) 
    public void setValue( String value ) {
        this.value = value;
    }
    public String getValue() {
        return this.value;
    }

    //--- DATABASE MAPPING : property ( TINYINT ) 
    public void setProperty( Byte property ) {
        this.property = property;
    }
    public Byte getProperty() {
        return this.property;
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
        sb.append(keyword);
        sb.append("|");
        sb.append(value);
        sb.append("|");
        sb.append(property);
        return sb.toString(); 
    } 

}
