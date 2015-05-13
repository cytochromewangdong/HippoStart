/*
 * Created on 13 五月 2015 ( Time 21:15:22 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.auto.model;

import java.io.Serializable;

import javax.validation.constraints.*;

import java.util.Date;

public class Account implements Serializable {

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


    protected Integer usernamehashcode;

    @Size( max = 100 )
    protected String email;


    protected Integer emailhashcode;

    @Size( max = 32 )
    protected String md5email;

    @Size( max = 32 )
    protected String password;

    @Size( max = 300 )
    protected String imageurl;

    @Size( max = 30 )
    protected String nickname;

    @Size( max = 250 )
    protected String address;

    @Size( max = 80 )
    protected String location;


    protected Byte usersource;

    @Size( max = 32 )
    protected String usersourcename;

    @Size( max = 32 )
    protected String externaluid;

    @Size( max = 50 )
    protected String externalusername;


    protected Byte emailverified;

    @Size( max = 64 )
    protected String mobiletoken;

    @Size( max = 20 )
    protected String language;


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

    public void setUsernamehashcode( Integer usernamehashcode ) {
        this.usernamehashcode = usernamehashcode;
    }
    public Integer getUsernamehashcode() {
        return this.usernamehashcode;
    }

    public void setEmail( String email ) {
        this.email = email;
    }
    public String getEmail() {
        return this.email;
    }

    public void setEmailhashcode( Integer emailhashcode ) {
        this.emailhashcode = emailhashcode;
    }
    public Integer getEmailhashcode() {
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

    public void setImageurl( String imageurl ) {
        this.imageurl = imageurl;
    }
    public String getImageurl() {
        return this.imageurl;
    }

    public void setNickname( String nickname ) {
        this.nickname = nickname;
    }
    public String getNickname() {
        return this.nickname;
    }

    public void setAddress( String address ) {
        this.address = address;
    }
    public String getAddress() {
        return this.address;
    }

    public void setLocation( String location ) {
        this.location = location;
    }
    public String getLocation() {
        return this.location;
    }

    public void setUsersource( Byte usersource ) {
        this.usersource = usersource;
    }
    public Byte getUsersource() {
        return this.usersource;
    }

    public void setUsersourcename( String usersourcename ) {
        this.usersourcename = usersourcename;
    }
    public String getUsersourcename() {
        return this.usersourcename;
    }

    public void setExternaluid( String externaluid ) {
        this.externaluid = externaluid;
    }
    public String getExternaluid() {
        return this.externaluid;
    }

    public void setExternalusername( String externalusername ) {
        this.externalusername = externalusername;
    }
    public String getExternalusername() {
        return this.externalusername;
    }

    public void setEmailverified( Byte emailverified ) {
        this.emailverified = emailverified;
    }
    public Byte getEmailverified() {
        return this.emailverified;
    }

    public void setMobiletoken( String mobiletoken ) {
        this.mobiletoken = mobiletoken;
    }
    public String getMobiletoken() {
        return this.mobiletoken;
    }

    public void setLanguage( String language ) {
        this.language = language;
    }
    public String getLanguage() {
        return this.language;
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
        sb.append(usernamehashcode);
        sb.append("|");
        sb.append(email);
        sb.append("|");
        sb.append(emailhashcode);
        sb.append("|");
        sb.append(md5email);
        sb.append("|");
        sb.append(password);
        sb.append("|");
        sb.append(imageurl);
        sb.append("|");
        sb.append(nickname);
        sb.append("|");
        sb.append(address);
        sb.append("|");
        sb.append(location);
        sb.append("|");
        sb.append(usersource);
        sb.append("|");
        sb.append(usersourcename);
        sb.append("|");
        sb.append(externaluid);
        sb.append("|");
        sb.append(externalusername);
        sb.append("|");
        sb.append(emailverified);
        sb.append("|");
        sb.append(mobiletoken);
        sb.append("|");
        sb.append(language);
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
