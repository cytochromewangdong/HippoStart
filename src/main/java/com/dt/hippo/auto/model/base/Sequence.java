/*
 * Created on 18 五月 2015 ( Time 17:57:11 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.auto.model.base;

import java.io.Serializable;

import javax.validation.constraints.*;


public class Sequence extends com.dt.hippo.core.base.BaseBeanCommon implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    @Size( min = 1, max = 20 )
    protected String keyword;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    

    protected Long no;



    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setKeyword( String keyword ) {
        this.keyword = keyword ;
    }

    public String getKeyword() {
        return this.keyword;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    public void setNo( Long no ) {
        this.no = no;
    }
    public Long getNo() {
        return this.no;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
 
        public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(no);
        sb.append("|");
        sb.append(keyword);
        return sb.toString(); 
    } 


}
