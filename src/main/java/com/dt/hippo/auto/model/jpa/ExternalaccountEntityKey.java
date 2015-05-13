/*
 * Created on 13 五月 2015 ( Time 21:15:26 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.auto.model.jpa;
import java.io.Serializable;

import javax.persistence.*;

/**
 * Composite primary key for entity "ExternalaccountEntity" ( stored in table "externalaccount" )
 *
 * @author Telosys Tools Generator
 *
 */
 @Embeddable
public class ExternalaccountEntityKey implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY KEY ATTRIBUTES 
    //----------------------------------------------------------------------
    @Column(name="userId", nullable=false)
    protected Long       userid       ;
    
    @Column(name="userSource", nullable=false)
    protected Byte       usersource   ;
    

    //----------------------------------------------------------------------
    // CONSTRUCTORS
    //----------------------------------------------------------------------
    public ExternalaccountEntityKey() {
        super();
    }

    public ExternalaccountEntityKey( Long userid, Byte usersource ) {
        super();
        this.userid = userid ;
        this.usersource = usersource ;
    }
    
    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR KEY FIELDS
    //----------------------------------------------------------------------
    public void setUserid( Long value ) {
        this.userid = value;
    }
    public Long getUserid() {
        return this.userid;
    }

    public void setUsersource( Byte value ) {
        this.usersource = value;
    }
    public Byte getUsersource() {
        return this.usersource;
    }


    //----------------------------------------------------------------------
    // equals METHOD
    //----------------------------------------------------------------------
	public boolean equals(Object obj) { 
		if ( this == obj ) return true ; 
		if ( obj == null ) return false ;
		if ( this.getClass() != obj.getClass() ) return false ; 
		ExternalaccountEntityKey other = (ExternalaccountEntityKey) obj; 
		//--- Attribute userid
		if ( userid == null ) { 
			if ( other.userid != null ) 
				return false ; 
		} else if ( ! userid.equals(other.userid) ) 
			return false ; 
		//--- Attribute usersource
		if ( usersource == null ) { 
			if ( other.usersource != null ) 
				return false ; 
		} else if ( ! usersource.equals(other.usersource) ) 
			return false ; 
		return true; 
	} 


    //----------------------------------------------------------------------
    // hashCode METHOD
    //----------------------------------------------------------------------
	public int hashCode() { 
		final int prime = 31; 
		int result = 1; 
		
		//--- Attribute userid
		result = prime * result + ((userid == null) ? 0 : userid.hashCode() ) ; 
		//--- Attribute usersource
		result = prime * result + ((usersource == null) ? 0 : usersource.hashCode() ) ; 
		
		return result; 
	} 


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() {
		StringBuffer sb = new StringBuffer(); 
		sb.append(userid); 
		sb.append("|"); 
		sb.append(usersource); 
        return sb.toString();
    }
}
