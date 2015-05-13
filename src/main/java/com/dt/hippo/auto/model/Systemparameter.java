/*
 * Created on 13 五月 2015 ( Time 21:15:32 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.auto.model;

import java.io.Serializable;

import javax.validation.constraints.*;


public class Systemparameter implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    protected Integer uid;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Size( max = 30 )
    protected String keyword;

    @Size( max = 100 )
    protected String value;


    protected Byte property;



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
    public void setKeyword( String keyword ) {
        this.keyword = keyword;
    }
    public String getKeyword() {
        return this.keyword;
    }

    public void setValue( String value ) {
        this.value = value;
    }
    public String getValue() {
        return this.value;
    }

    public void setProperty( Byte property ) {
        this.property = property;
    }
    public Byte getProperty() {
        return this.property;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
 
        public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(uid);
        sb.append("|");
        sb.append(keyword);
        sb.append("|");
        sb.append(value);
        sb.append("|");
        sb.append(property);
        return sb.toString(); 
    } 


}
