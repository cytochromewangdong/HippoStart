/*
 * Created on 27 五月 2015 ( Time 17:36:24 )
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
 * Persistent class for entity stored in table "orderdetail"
 *
 * @author Telosys Tools Generator
 *
 */
@MappedSuperclass
//@Entity
@Table(name="orderdetail", catalog="hippo" )
// Define named queries here
//@NamedQueries ( {
//  @NamedQuery ( name="OrderdetailEntity.countAll", query="SELECT COUNT(x) FROM OrderdetailEntity x" )
//} )
public class OrderdetailEntity extends com.dt.hippo.core.base.BaseBeanCommon implements Serializable {

    protected static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    protected Long       uid          ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    protected Integer    no           ;

    protected Long       orderuid     ;

    protected String     orderno      ;

    protected Long       itemid       ;

    protected Long       price        ;

    protected Long       priceatsale  ;

    protected Long       amountmoney  ;

    protected Long       amountatsale ;

    protected Integer    amount       ;

    protected Integer    type         ;

    protected Long       promotionuid ;

    protected Long       specificationid ;

    protected Date       createdate   ;

    protected Date       modifydate   ;

    protected String     createuser   ;

    protected String     modifyuser   ;

    protected Byte       delflg       ;

    protected String     platform     ;



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public OrderdetailEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setUid( Long uid ) {
        this.uid = uid ;
    }
       @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="uid", nullable=false)
  public Long getUid() {
        return this.uid;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : no ( INT ) 
    public void setNo( Integer no ) {
        this.no = no;
    }
       @Column(name="no")
 public Integer getNo() {
        return this.no;
    }

    //--- DATABASE MAPPING : orderUid ( BIGINT ) 
    public void setOrderuid( Long orderuid ) {
        this.orderuid = orderuid;
    }
       @Column(name="orderUid")
 public Long getOrderuid() {
        return this.orderuid;
    }

    //--- DATABASE MAPPING : orderNo ( VARCHAR ) 
    public void setOrderno( String orderno ) {
        this.orderno = orderno;
    }
       @Column(name="orderNo", length=50)
 public String getOrderno() {
        return this.orderno;
    }

    //--- DATABASE MAPPING : itemId ( BIGINT ) 
    public void setItemid( Long itemid ) {
        this.itemid = itemid;
    }
       @Column(name="itemId")
 public Long getItemid() {
        return this.itemid;
    }

    //--- DATABASE MAPPING : price ( BIGINT ) 
    public void setPrice( Long price ) {
        this.price = price;
    }
       @Column(name="price")
 public Long getPrice() {
        return this.price;
    }

    //--- DATABASE MAPPING : priceAtSale ( BIGINT ) 
    public void setPriceatsale( Long priceatsale ) {
        this.priceatsale = priceatsale;
    }
       @Column(name="priceAtSale")
 public Long getPriceatsale() {
        return this.priceatsale;
    }

    //--- DATABASE MAPPING : amountMoney ( BIGINT ) 
    public void setAmountmoney( Long amountmoney ) {
        this.amountmoney = amountmoney;
    }
       @Column(name="amountMoney")
 public Long getAmountmoney() {
        return this.amountmoney;
    }

    //--- DATABASE MAPPING : amountAtSale ( BIGINT ) 
    public void setAmountatsale( Long amountatsale ) {
        this.amountatsale = amountatsale;
    }
       @Column(name="amountAtSale")
 public Long getAmountatsale() {
        return this.amountatsale;
    }

    //--- DATABASE MAPPING : amount ( INT ) 
    public void setAmount( Integer amount ) {
        this.amount = amount;
    }
       @Column(name="amount")
 public Integer getAmount() {
        return this.amount;
    }

    //--- DATABASE MAPPING : type ( INT ) 
    public void setType( Integer type ) {
        this.type = type;
    }
       @Column(name="type")
 public Integer getType() {
        return this.type;
    }

    //--- DATABASE MAPPING : promotionUid ( BIGINT ) 
    public void setPromotionuid( Long promotionuid ) {
        this.promotionuid = promotionuid;
    }
       @Column(name="promotionUid")
 public Long getPromotionuid() {
        return this.promotionuid;
    }

    //--- DATABASE MAPPING : specificationId ( BIGINT ) 
    public void setSpecificationid( Long specificationid ) {
        this.specificationid = specificationid;
    }
       @Column(name="specificationId")
 public Long getSpecificationid() {
        return this.specificationid;
    }

    //--- DATABASE MAPPING : createDate ( DATETIME ) 
    public void setCreatedate( Date createdate ) {
        this.createdate = createdate;
    }
       @Temporal(TemporalType.TIMESTAMP)
    @Column(name="createDate")
 public Date getCreatedate() {
        return this.createdate;
    }

    //--- DATABASE MAPPING : modifyDate ( DATETIME ) 
    public void setModifydate( Date modifydate ) {
        this.modifydate = modifydate;
    }
       @Temporal(TemporalType.TIMESTAMP)
    @Column(name="modifyDate")
 public Date getModifydate() {
        return this.modifydate;
    }

    //--- DATABASE MAPPING : createUser ( VARCHAR ) 
    public void setCreateuser( String createuser ) {
        this.createuser = createuser;
    }
       @Column(name="createUser", length=50)
 public String getCreateuser() {
        return this.createuser;
    }

    //--- DATABASE MAPPING : modifyUser ( VARCHAR ) 
    public void setModifyuser( String modifyuser ) {
        this.modifyuser = modifyuser;
    }
       @Column(name="modifyUser", length=50)
 public String getModifyuser() {
        return this.modifyuser;
    }

    //--- DATABASE MAPPING : delFlg ( TINYINT ) 
    public void setDelflg( Byte delflg ) {
        this.delflg = delflg;
    }
       @Column(name="delFlg")
 public Byte getDelflg() {
        return this.delflg;
    }

    //--- DATABASE MAPPING : platform ( VARCHAR ) 
    public void setPlatform( String platform ) {
        this.platform = platform;
    }
       @Column(name="platform", length=50)
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
        sb.append(no);
        sb.append("|");
        sb.append(orderuid);
        sb.append("|");
        sb.append(orderno);
        sb.append("|");
        sb.append(itemid);
        sb.append("|");
        sb.append(price);
        sb.append("|");
        sb.append(priceatsale);
        sb.append("|");
        sb.append(amountmoney);
        sb.append("|");
        sb.append(amountatsale);
        sb.append("|");
        sb.append(amount);
        sb.append("|");
        sb.append(type);
        sb.append("|");
        sb.append(promotionuid);
        sb.append("|");
        sb.append(specificationid);
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
