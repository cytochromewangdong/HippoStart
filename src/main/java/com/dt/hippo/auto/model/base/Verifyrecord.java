/*
 * Created on 18 五月 2015 ( Time 17:57:12 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.auto.model.base;

import java.io.Serializable;

import javax.validation.constraints.*;

import java.util.Date;

public class Verifyrecord extends com.dt.hippo.core.base.BaseBeanCommon implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    protected Long uid;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    

    protected Byte verifytype;


    protected Long userid;

    @Size( max = 50 )
    protected String username;

    @Size( max = 100 )
    protected String email;

    @Size( max = 30 )
    protected String randomcode;


    protected Date expiretime;


    protected Byte resetflg;


    protected Date createdate;


    protected Date modifydate;

    @Size( max = 50 )
    protected String createuser;

    @Size( max = 50 )
    protected String modifyuser;


    protected Byte delflg;

    @Size( max = 50 )
    protected String platform;



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
    public void setVerifytype( Byte verifytype ) {
        this.verifytype = verifytype;
    }
    public Byte getVerifytype() {
        return this.verifytype;
    }

    public void setUserid( Long userid ) {
        this.userid = userid;
    }
    public Long getUserid() {
        return this.userid;
    }

    public void setUsername( String username ) {
        this.username = username;
    }
    public String getUsername() {
        return this.username;
    }

    public void setEmail( String email ) {
        this.email = email;
    }
    public String getEmail() {
        return this.email;
    }

    public void setRandomcode( String randomcode ) {
        this.randomcode = randomcode;
    }
    public String getRandomcode() {
        return this.randomcode;
    }

    public void setExpiretime( Date expiretime ) {
        this.expiretime = expiretime;
    }
    public Date getExpiretime() {
        return this.expiretime;
    }

    public void setResetflg( Byte resetflg ) {
        this.resetflg = resetflg;
    }
    public Byte getResetflg() {
        return this.resetflg;
    }

    public void setCreatedate( Date createdate ) {
        this.createdate = createdate;
    }
    public Date getCreatedate() {
        return this.createdate;
    }

    public void setModifydate( Date modifydate ) {
        this.modifydate = modifydate;
    }
    public Date getModifydate() {
        return this.modifydate;
    }

    public void setCreateuser( String createuser ) {
        this.createuser = createuser;
    }
    public String getCreateuser() {
        return this.createuser;
    }

    public void setModifyuser( String modifyuser ) {
        this.modifyuser = modifyuser;
    }
    public String getModifyuser() {
        return this.modifyuser;
    }

    public void setDelflg( Byte delflg ) {
        this.delflg = delflg;
    }
    public Byte getDelflg() {
        return this.delflg;
    }

    public void setPlatform( String platform ) {
        this.platform = platform;
    }
    public String getPlatform() {
        return this.platform;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
 
        public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(uid);
        sb.append("|");
        sb.append(verifytype);
        sb.append("|");
        sb.append(userid);
        sb.append("|");
        sb.append(username);
        sb.append("|");
        sb.append(email);
        sb.append("|");
        sb.append(randomcode);
        sb.append("|");
        sb.append(expiretime);
        sb.append("|");
        sb.append(resetflg);
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
