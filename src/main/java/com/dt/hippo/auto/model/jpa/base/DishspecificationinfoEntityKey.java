/*
 * Created on 14 五月 2015 ( Time 21:14:04 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.auto.model.jpa.base;
import java.io.Serializable;

import javax.persistence.*;

/**
 * Composite primary key for entity "DishspecificationinfoEntity" ( stored in table "dishSpecificationInfo" )
 *
 * @author Telosys Tools Generator
 *
 */
 @Embeddable
public class DishspecificationinfoEntityKey implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY KEY ATTRIBUTES 
    //----------------------------------------------------------------------
    @Column(name="dishId", nullable=false)
    protected Long       dishid       ;
    
    @Column(name="uid", nullable=false)
    protected Long       uid          ;
    

    //----------------------------------------------------------------------
    // CONSTRUCTORS
    //----------------------------------------------------------------------
    public DishspecificationinfoEntityKey() {
        super();
    }

    public DishspecificationinfoEntityKey( Long dishid, Long uid ) {
        super();
        this.dishid = dishid ;
        this.uid = uid ;
    }
    
    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR KEY FIELDS
    //----------------------------------------------------------------------
    public void setDishid( Long value ) {
        this.dishid = value;
    }
    public Long getDishid() {
        return this.dishid;
    }

    public void setUid( Long value ) {
        this.uid = value;
    }
    public Long getUid() {
        return this.uid;
    }


    //----------------------------------------------------------------------
    // equals METHOD
    //----------------------------------------------------------------------
	public boolean equals(Object obj) { 
		if ( this == obj ) return true ; 
		if ( obj == null ) return false ;
		if ( this.getClass() != obj.getClass() ) return false ; 
		DishspecificationinfoEntityKey other = (DishspecificationinfoEntityKey) obj; 
		//--- Attribute dishid
		if ( dishid == null ) { 
			if ( other.dishid != null ) 
				return false ; 
		} else if ( ! dishid.equals(other.dishid) ) 
			return false ; 
		//--- Attribute uid
		if ( uid == null ) { 
			if ( other.uid != null ) 
				return false ; 
		} else if ( ! uid.equals(other.uid) ) 
			return false ; 
		return true; 
	} 


    //----------------------------------------------------------------------
    // hashCode METHOD
    //----------------------------------------------------------------------
	public int hashCode() { 
		final int prime = 31; 
		int result = 1; 
		
		//--- Attribute dishid
		result = prime * result + ((dishid == null) ? 0 : dishid.hashCode() ) ; 
		//--- Attribute uid
		result = prime * result + ((uid == null) ? 0 : uid.hashCode() ) ; 
		
		return result; 
	} 


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() {
		StringBuffer sb = new StringBuffer(); 
		sb.append(dishid); 
		sb.append("|"); 
		sb.append(uid); 
        return sb.toString();
    }
}
