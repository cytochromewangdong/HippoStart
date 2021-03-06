/*
 * Created on 18 五月 2015 ( Time 17:57:10 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.auto.model.base;

import java.io.Serializable;

import javax.validation.constraints.*;

import java.util.Date;

public class Cateringcorpinfo extends com.dt.hippo.core.base.BaseBeanCommon implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    protected Long uid;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Size( max = 32 )
    protected String corpno;

    @Size( max = 100 )
    protected String corpname;

    @Size( max = 1000 )
    protected String corpdescription;

    @Size( max = 25 )
    protected String phone;

    @Size( max = 300 )
    protected String logourl;


    protected Integer storeamount;


    protected Date createdate;


    protected Date modifydate;

    @Size( max = 50 )
    protected String createuser;

    @Size( max = 50 )
    protected String modifyuser;


    protected Integer status;

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
    public void setCorpno( String corpno ) {
        this.corpno = corpno;
    }
    public String getCorpno() {
        return this.corpno;
    }

    public void setCorpname( String corpname ) {
        this.corpname = corpname;
    }
    public String getCorpname() {
        return this.corpname;
    }

    public void setCorpdescription( String corpdescription ) {
        this.corpdescription = corpdescription;
    }
    public String getCorpdescription() {
        return this.corpdescription;
    }

    public void setPhone( String phone ) {
        this.phone = phone;
    }
    public String getPhone() {
        return this.phone;
    }

    public void setLogourl( String logourl ) {
        this.logourl = logourl;
    }
    public String getLogourl() {
        return this.logourl;
    }

    public void setStoreamount( Integer storeamount ) {
        this.storeamount = storeamount;
    }
    public Integer getStoreamount() {
        return this.storeamount;
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

    public void setStatus( Integer status ) {
        this.status = status;
    }
    public Integer getStatus() {
        return this.status;
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
        sb.append(corpno);
        sb.append("|");
        sb.append(corpname);
        sb.append("|");
        sb.append(corpdescription);
        sb.append("|");
        sb.append(phone);
        sb.append("|");
        sb.append(logourl);
        sb.append("|");
        sb.append(storeamount);
        sb.append("|");
        sb.append(createdate);
        sb.append("|");
        sb.append(modifydate);
        sb.append("|");
        sb.append(createuser);
        sb.append("|");
        sb.append(modifyuser);
        sb.append("|");
        sb.append(status);
        sb.append("|");
        sb.append(platform);
        return sb.toString(); 
    } 


}
