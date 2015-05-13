/*
 * Created on 13 五月 2015 ( Time 21:15:22 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.dt.hippo.auto.model.jpa.base;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.util.Date;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "account"
 *
 * @author Telosys Tools Generator
 *
 */
@MappedSuperclass
//@Entity
@Table(name="account", catalog="hippo" )
// Define named queries here
//@NamedQueries ( {
//  @NamedQuery ( name="AccountEntity.countAll", query="SELECT COUNT(x) FROM AccountEntity x" )
//} )
public class AccountEntity implements Serializable {

    protected static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name="uid", nullable=false)
    protected Long       uid          ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="userName", length=50)
    protected String     username     ;

    @Column(name="usernameHashcode")
    protected Integer    usernamehashcode ;

    @Column(name="email", length=100)
    protected String     email        ;

    @Column(name="emailHashcode")
    protected Integer    emailhashcode ;

    @Column(name="md5email", length=32)
    protected String     md5email     ;

    @Column(name="password", length=32)
    protected String     password     ;

    @Column(name="imageUrl", length=300)
    protected String     imageurl     ;

    @Column(name="nickname", length=30)
    protected String     nickname     ;

    @Column(name="address", length=250)
    protected String     address      ;

    @Column(name="location", length=80)
    protected String     location     ;

    @Column(name="usersource")
    protected Byte       usersource   ;

    @Column(name="usersourceName", length=32)
    protected String     usersourcename ;

    @Column(name="externalUID", length=32)
    protected String     externaluid  ;

    @Column(name="externalUserName", length=50)
    protected String     externalusername ;

    @Column(name="emailVerified")
    protected Byte       emailverified ;

    @Column(name="mobileToken", length=64)
    protected String     mobiletoken  ;

    @Column(name="language", length=20)
    protected String     language     ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="createDate")
    protected Date       createdate   ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="modifyDate")
    protected Date       modifydate   ;

    @Column(name="createUser", length=50)
    protected String     createuser   ;

    @Column(name="modifyUser", length=50)
    protected String     modifyuser   ;

    @Column(name="delFlg")
    protected Byte       delflg       ;

    @Column(name="platform", length=50)
    protected String     platform     ;



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public AccountEntity() {
		super();
    }
    
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
    //--- DATABASE MAPPING : userName ( VARCHAR ) 
    public void setUsername( String username ) {
        this.username = username;
    }
    public String getUsername() {
        return this.username;
    }

    //--- DATABASE MAPPING : usernameHashcode ( INT ) 
    public void setUsernamehashcode( Integer usernamehashcode ) {
        this.usernamehashcode = usernamehashcode;
    }
    public Integer getUsernamehashcode() {
        return this.usernamehashcode;
    }

    //--- DATABASE MAPPING : email ( VARCHAR ) 
    public void setEmail( String email ) {
        this.email = email;
    }
    public String getEmail() {
        return this.email;
    }

    //--- DATABASE MAPPING : emailHashcode ( INT ) 
    public void setEmailhashcode( Integer emailhashcode ) {
        this.emailhashcode = emailhashcode;
    }
    public Integer getEmailhashcode() {
        return this.emailhashcode;
    }

    //--- DATABASE MAPPING : md5email ( VARCHAR ) 
    public void setMd5email( String md5email ) {
        this.md5email = md5email;
    }
    public String getMd5email() {
        return this.md5email;
    }

    //--- DATABASE MAPPING : password ( VARCHAR ) 
    public void setPassword( String password ) {
        this.password = password;
    }
    public String getPassword() {
        return this.password;
    }

    //--- DATABASE MAPPING : imageUrl ( VARCHAR ) 
    public void setImageurl( String imageurl ) {
        this.imageurl = imageurl;
    }
    public String getImageurl() {
        return this.imageurl;
    }

    //--- DATABASE MAPPING : nickname ( VARCHAR ) 
    public void setNickname( String nickname ) {
        this.nickname = nickname;
    }
    public String getNickname() {
        return this.nickname;
    }

    //--- DATABASE MAPPING : address ( VARCHAR ) 
    public void setAddress( String address ) {
        this.address = address;
    }
    public String getAddress() {
        return this.address;
    }

    //--- DATABASE MAPPING : location ( VARCHAR ) 
    public void setLocation( String location ) {
        this.location = location;
    }
    public String getLocation() {
        return this.location;
    }

    //--- DATABASE MAPPING : usersource ( TINYINT ) 
    public void setUsersource( Byte usersource ) {
        this.usersource = usersource;
    }
    public Byte getUsersource() {
        return this.usersource;
    }

    //--- DATABASE MAPPING : usersourceName ( VARCHAR ) 
    public void setUsersourcename( String usersourcename ) {
        this.usersourcename = usersourcename;
    }
    public String getUsersourcename() {
        return this.usersourcename;
    }

    //--- DATABASE MAPPING : externalUID ( VARCHAR ) 
    public void setExternaluid( String externaluid ) {
        this.externaluid = externaluid;
    }
    public String getExternaluid() {
        return this.externaluid;
    }

    //--- DATABASE MAPPING : externalUserName ( VARCHAR ) 
    public void setExternalusername( String externalusername ) {
        this.externalusername = externalusername;
    }
    public String getExternalusername() {
        return this.externalusername;
    }

    //--- DATABASE MAPPING : emailVerified ( TINYINT ) 
    public void setEmailverified( Byte emailverified ) {
        this.emailverified = emailverified;
    }
    public Byte getEmailverified() {
        return this.emailverified;
    }

    //--- DATABASE MAPPING : mobileToken ( VARCHAR ) 
    public void setMobiletoken( String mobiletoken ) {
        this.mobiletoken = mobiletoken;
    }
    public String getMobiletoken() {
        return this.mobiletoken;
    }

    //--- DATABASE MAPPING : language ( VARCHAR ) 
    public void setLanguage( String language ) {
        this.language = language;
    }
    public String getLanguage() {
        return this.language;
    }

    //--- DATABASE MAPPING : createDate ( DATETIME ) 
    public void setCreatedate( Date createdate ) {
        this.createdate = createdate;
    }
    public Date getCreatedate() {
        return this.createdate;
    }

    //--- DATABASE MAPPING : modifyDate ( DATETIME ) 
    public void setModifydate( Date modifydate ) {
        this.modifydate = modifydate;
    }
    public Date getModifydate() {
        return this.modifydate;
    }

    //--- DATABASE MAPPING : createUser ( VARCHAR ) 
    public void setCreateuser( String createuser ) {
        this.createuser = createuser;
    }
    public String getCreateuser() {
        return this.createuser;
    }

    //--- DATABASE MAPPING : modifyUser ( VARCHAR ) 
    public void setModifyuser( String modifyuser ) {
        this.modifyuser = modifyuser;
    }
    public String getModifyuser() {
        return this.modifyuser;
    }

    //--- DATABASE MAPPING : delFlg ( TINYINT ) 
    public void setDelflg( Byte delflg ) {
        this.delflg = delflg;
    }
    public Byte getDelflg() {
        return this.delflg;
    }

    //--- DATABASE MAPPING : platform ( VARCHAR ) 
    public void setPlatform( String platform ) {
        this.platform = platform;
    }
    public String getPlatform() {
        return this.platform;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(uid);
        sb.append("]:"); 
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
