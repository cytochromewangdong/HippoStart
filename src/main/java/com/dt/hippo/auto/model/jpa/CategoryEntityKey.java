/*
 * Created on 13 五月 2015 ( Time 21:15:23 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.auto.model.jpa;
import java.io.Serializable;

import javax.persistence.*;

/**
 * Composite primary key for entity "CategoryEntity" ( stored in table "category" )
 *
 * @author Telosys Tools Generator
 *
 */
 @Embeddable
public class CategoryEntityKey implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY KEY ATTRIBUTES 
    //----------------------------------------------------------------------
    @Column(name="corpId", nullable=false)
    protected Long       corpid       ;
    
    @Column(name="uid", nullable=false, length=5)
    protected String     uid          ;
    

    //----------------------------------------------------------------------
    // CONSTRUCTORS
    //----------------------------------------------------------------------
    public CategoryEntityKey() {
        super();
    }

    public CategoryEntityKey( Long corpid, String uid ) {
        super();
        this.corpid = corpid ;
        this.uid = uid ;
    }
    
    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR KEY FIELDS
    //----------------------------------------------------------------------
    public void setCorpid( Long value ) {
        this.corpid = value;
    }
    public Long getCorpid() {
        return this.corpid;
    }

    public void setUid( String value ) {
        this.uid = value;
    }
    public String getUid() {
        return this.uid;
    }


    //----------------------------------------------------------------------
    // equals METHOD
    //----------------------------------------------------------------------
	public boolean equals(Object obj) { 
		if ( this == obj ) return true ; 
		if ( obj == null ) return false ;
		if ( this.getClass() != obj.getClass() ) return false ; 
		CategoryEntityKey other = (CategoryEntityKey) obj; 
		//--- Attribute corpid
		if ( corpid == null ) { 
			if ( other.corpid != null ) 
				return false ; 
		} else if ( ! corpid.equals(other.corpid) ) 
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
		
		//--- Attribute corpid
		result = prime * result + ((corpid == null) ? 0 : corpid.hashCode() ) ; 
		//--- Attribute uid
		result = prime * result + ((uid == null) ? 0 : uid.hashCode() ) ; 
		
		return result; 
	} 


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() {
		StringBuffer sb = new StringBuffer(); 
		sb.append(corpid); 
		sb.append("|"); 
		sb.append(uid); 
        return sb.toString();
    }
}
