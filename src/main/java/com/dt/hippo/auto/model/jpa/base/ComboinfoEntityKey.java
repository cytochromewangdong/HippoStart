/*
 * Created on 13 五月 2015 ( Time 21:15:24 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.auto.model.jpa.base;
import java.io.Serializable;

import javax.persistence.*;

/**
 * Composite primary key for entity "ComboinfoEntity" ( stored in table "comboinfo" )
 *
 * @author Telosys Tools Generator
 *
 */
 @Embeddable
public class ComboinfoEntityKey implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY KEY ATTRIBUTES 
    //----------------------------------------------------------------------
    @Column(name="uid", nullable=false)
    protected Long       uid          ;
    
    @Column(name="childId", nullable=false)
    protected Long       childid      ;
    
    @Column(name="specificationId", nullable=false)
    protected Long       specificationid ;
    

    //----------------------------------------------------------------------
    // CONSTRUCTORS
    //----------------------------------------------------------------------
    public ComboinfoEntityKey() {
        super();
    }

    public ComboinfoEntityKey( Long uid, Long childid, Long specificationid ) {
        super();
        this.uid = uid ;
        this.childid = childid ;
        this.specificationid = specificationid ;
    }
    
    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR KEY FIELDS
    //----------------------------------------------------------------------
    public void setUid( Long value ) {
        this.uid = value;
    }
    public Long getUid() {
        return this.uid;
    }

    public void setChildid( Long value ) {
        this.childid = value;
    }
    public Long getChildid() {
        return this.childid;
    }

    public void setSpecificationid( Long value ) {
        this.specificationid = value;
    }
    public Long getSpecificationid() {
        return this.specificationid;
    }


    //----------------------------------------------------------------------
    // equals METHOD
    //----------------------------------------------------------------------
	public boolean equals(Object obj) { 
		if ( this == obj ) return true ; 
		if ( obj == null ) return false ;
		if ( this.getClass() != obj.getClass() ) return false ; 
		ComboinfoEntityKey other = (ComboinfoEntityKey) obj; 
		//--- Attribute uid
		if ( uid == null ) { 
			if ( other.uid != null ) 
				return false ; 
		} else if ( ! uid.equals(other.uid) ) 
			return false ; 
		//--- Attribute childid
		if ( childid == null ) { 
			if ( other.childid != null ) 
				return false ; 
		} else if ( ! childid.equals(other.childid) ) 
			return false ; 
		//--- Attribute specificationid
		if ( specificationid == null ) { 
			if ( other.specificationid != null ) 
				return false ; 
		} else if ( ! specificationid.equals(other.specificationid) ) 
			return false ; 
		return true; 
	} 


    //----------------------------------------------------------------------
    // hashCode METHOD
    //----------------------------------------------------------------------
	public int hashCode() { 
		final int prime = 31; 
		int result = 1; 
		
		//--- Attribute uid
		result = prime * result + ((uid == null) ? 0 : uid.hashCode() ) ; 
		//--- Attribute childid
		result = prime * result + ((childid == null) ? 0 : childid.hashCode() ) ; 
		//--- Attribute specificationid
		result = prime * result + ((specificationid == null) ? 0 : specificationid.hashCode() ) ; 
		
		return result; 
	} 


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() {
		StringBuffer sb = new StringBuffer(); 
		sb.append(uid); 
		sb.append("|"); 
		sb.append(childid); 
		sb.append("|"); 
		sb.append(specificationid); 
        return sb.toString();
    }
}