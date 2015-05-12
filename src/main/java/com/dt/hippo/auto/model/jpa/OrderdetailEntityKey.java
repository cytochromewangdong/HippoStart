/*
 * Created on 12 五月 2015 ( Time 20:53:03 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.auto.model.jpa;
import java.io.Serializable;

import javax.persistence.*;

/**
 * Composite primary key for entity "OrderdetailEntity" ( stored in table "orderdetail" )
 *
 * @author Telosys Tools Generator
 *
 */
 @Embeddable
public class OrderdetailEntityKey implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY KEY ATTRIBUTES 
    //----------------------------------------------------------------------
    @Column(name="orderNo", nullable=false, length=50)
    protected String     orderno      ;
    
    @Column(name="uid", nullable=false)
    protected Long       uid          ;
    

    //----------------------------------------------------------------------
    // CONSTRUCTORS
    //----------------------------------------------------------------------
    public OrderdetailEntityKey() {
        super();
    }

    public OrderdetailEntityKey( String orderno, Long uid ) {
        super();
        this.orderno = orderno ;
        this.uid = uid ;
    }
    
    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR KEY FIELDS
    //----------------------------------------------------------------------
    public void setOrderno( String value ) {
        this.orderno = value;
    }
    public String getOrderno() {
        return this.orderno;
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
		OrderdetailEntityKey other = (OrderdetailEntityKey) obj; 
		//--- Attribute orderno
		if ( orderno == null ) { 
			if ( other.orderno != null ) 
				return false ; 
		} else if ( ! orderno.equals(other.orderno) ) 
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
		
		//--- Attribute orderno
		result = prime * result + ((orderno == null) ? 0 : orderno.hashCode() ) ; 
		//--- Attribute uid
		result = prime * result + ((uid == null) ? 0 : uid.hashCode() ) ; 
		
		return result; 
	} 


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() {
		StringBuffer sb = new StringBuffer(); 
		sb.append(orderno); 
		sb.append("|"); 
		sb.append(uid); 
        return sb.toString();
    }
}
