/*
 * Created on 18 五月 2015 ( Time 17:57:10 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.auto.model.base;

import java.io.Serializable;

import javax.validation.constraints.*;

import java.util.Date;

public class Administrator extends com.dt.hippo.core.base.BaseBeanCommon implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    protected Long uid;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Size( max = 50 )
    protected String username;

    @Size( max = 50 )
    protected String upperusername;


    protected Long usernamehashcode;

    @Size( max = 100 )
    protected String email;

    @Size( max = 100 )
    protected String upperemail;


    protected Long emailhashcode;

    @Size( max = 32 )
    protected String md5email;

    @Size( max = 32 )
    protected String password;

    @Size( max = 6 )
    protected String random;

    @Size( max = 150 )
    protected String imageurl;


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
    public void setUsername( String username ) {
        this.username = username;
    }
    public String getUsername() {
        return this.username;
    }

    public void setUpperusername( String upperusername ) {
        this.upperusername = upperusername;
    }
    public String getUpperusername() {
        return this.upperusername;
    }

    public void setUsernamehashcode( Long usernamehashcode ) {
        this.usernamehashcode = usernamehashcode;
    }
    public Long getUsernamehashcode() {
        return this.usernamehashcode;
    }

    public void setEmail( String email ) {
        this.email = email;
    }
    public String getEmail() {
        return this.email;
    }

    public void setUpperemail( String upperemail ) {
        this.upperemail = upperemail;
    }
    public String getUpperemail() {
        return this.upperemail;
    }

    public void setEmailhashcode( Long emailhashcode ) {
        this.emailhashcode = emailhashcode;
    }
    public Long getEmailhashcode() {
        return this.emailhashcode;
    }

    public void setMd5email( String md5email ) {
        this.md5email = md5email;
    }
    public String getMd5email() {
        return this.md5email;
    }

    public void setPassword( String password ) {
        this.password = password;
    }
    public String getPassword() {
        return this.password;
    }

    public void setRandom( String random ) {
        this.random = random;
    }
    public String getRandom() {
        return this.random;
    }

    public void setImageurl( String imageurl ) {
        this.imageurl = imageurl;
    }
    public String getImageurl() {
        return this.imageurl;
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
        sb.append(username);
        sb.append("|");
        sb.append(upperusername);
        sb.append("|");
        sb.append(usernamehashcode);
        sb.append("|");
        sb.append(email);
        sb.append("|");
        sb.append(upperemail);
        sb.append("|");
        sb.append(emailhashcode);
        sb.append("|");
        sb.append(md5email);
        sb.append("|");
        sb.append(password);
        sb.append("|");
        sb.append(random);
        sb.append("|");
        sb.append(imageurl);
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
