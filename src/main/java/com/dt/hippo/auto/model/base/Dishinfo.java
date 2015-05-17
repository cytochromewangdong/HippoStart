/*
 * Created on 16 五月 2015 ( Time 16:12:43 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.auto.model.base;

import java.io.Serializable;

import javax.validation.constraints.*;

import java.util.Date;

public class Dishinfo implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    protected Long uid;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    

    protected Long corpid;

    @Size( max = 10 )
    protected String no;

    @Size( max = 5 )
    protected String categoryid;

    @Size( max = 200 )
    protected String dishname;

    @Size( max = 300 )
    protected String dishdescription;

    @Size( max = 300 )
    protected String imageurl;


    protected Double price;


    protected Byte type;


    protected Byte hasspecification;


    protected Integer startdate;


    protected Integer enddate;


    protected Byte paused;


    protected Integer promotionstarttime;


    protected Integer promotionendtime;


    protected Double promotionprice;


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
    public void setCorpid( Long corpid ) {
        this.corpid = corpid;
    }
    public Long getCorpid() {
        return this.corpid;
    }

    public void setNo( String no ) {
        this.no = no;
    }
    public String getNo() {
        return this.no;
    }

    public void setCategoryid( String categoryid ) {
        this.categoryid = categoryid;
    }
    public String getCategoryid() {
        return this.categoryid;
    }

    public void setDishname( String dishname ) {
        this.dishname = dishname;
    }
    public String getDishname() {
        return this.dishname;
    }

    public void setDishdescription( String dishdescription ) {
        this.dishdescription = dishdescription;
    }
    public String getDishdescription() {
        return this.dishdescription;
    }

    public void setImageurl( String imageurl ) {
        this.imageurl = imageurl;
    }
    public String getImageurl() {
        return this.imageurl;
    }

    public void setPrice( Double price ) {
        this.price = price;
    }
    public Double getPrice() {
        return this.price;
    }

    public void setType( Byte type ) {
        this.type = type;
    }
    public Byte getType() {
        return this.type;
    }

    public void setHasspecification( Byte hasspecification ) {
        this.hasspecification = hasspecification;
    }
    public Byte getHasspecification() {
        return this.hasspecification;
    }

    public void setStartdate( Integer startdate ) {
        this.startdate = startdate;
    }
    public Integer getStartdate() {
        return this.startdate;
    }

    public void setEnddate( Integer enddate ) {
        this.enddate = enddate;
    }
    public Integer getEnddate() {
        return this.enddate;
    }

    public void setPaused( Byte paused ) {
        this.paused = paused;
    }
    public Byte getPaused() {
        return this.paused;
    }

    public void setPromotionstarttime( Integer promotionstarttime ) {
        this.promotionstarttime = promotionstarttime;
    }
    public Integer getPromotionstarttime() {
        return this.promotionstarttime;
    }

    public void setPromotionendtime( Integer promotionendtime ) {
        this.promotionendtime = promotionendtime;
    }
    public Integer getPromotionendtime() {
        return this.promotionendtime;
    }

    public void setPromotionprice( Double promotionprice ) {
        this.promotionprice = promotionprice;
    }
    public Double getPromotionprice() {
        return this.promotionprice;
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
        sb.append(corpid);
        sb.append("|");
        sb.append(no);
        sb.append("|");
        sb.append(categoryid);
        sb.append("|");
        sb.append(dishname);
        sb.append("|");
        sb.append(dishdescription);
        sb.append("|");
        sb.append(imageurl);
        sb.append("|");
        sb.append(price);
        sb.append("|");
        sb.append(type);
        sb.append("|");
        sb.append(hasspecification);
        sb.append("|");
        sb.append(startdate);
        sb.append("|");
        sb.append(enddate);
        sb.append("|");
        sb.append(paused);
        sb.append("|");
        sb.append(promotionstarttime);
        sb.append("|");
        sb.append(promotionendtime);
        sb.append("|");
        sb.append(promotionprice);
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
