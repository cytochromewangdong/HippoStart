/*
 * Created on 18 五月 2015 ( Time 11:07:11 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.dt.hippo.auto.model.jpa;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

//import com.dt.hippo.auto.model.jpa.base.DishinfoEntity;
/**
 * Persistent class for entity stored in table "dishinfo"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="dishinfo", catalog="hippo" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="DishinfoEntity.countAll", query="SELECT COUNT(x) FROM DishinfoEntity x" )
} )
@AttributeOverrides({
 //@AttributeOverride(name = "corpid", column = @Column(name = "corpId", insertable = false, updatable = false))
 //,  @AttributeOverride(name = "categoryid", column = @Column(name = "categoryId", insertable = false, updatable = false))

})
public class DishinfoEntity extends com.dt.hippo.auto.model.jpa.base.DishinfoEntity implements Serializable {

   protected static final long serialVersionUID = 8L;

     //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    protected CategoryEntity category    ;
    
    protected List<DishspecificationinfoEntity> listOfDishspecificationinfo;


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setCategory( CategoryEntity category ) {
        this.category = category;
    }
    @ManyToOne
    @JoinColumns( { 
        @JoinColumn(name="corpId", referencedColumnName="corpId", insertable = false, updatable = false),
        @JoinColumn(name="categoryId", referencedColumnName="uid",insertable = false, updatable = false) } )
    public CategoryEntity getCategory() {
        return this.category;
    }

    public void setListOfDishspecificationinfo( List<DishspecificationinfoEntity> listOfDishspecificationinfo ) {
        this.listOfDishspecificationinfo = listOfDishspecificationinfo;
    }
    
    @OneToMany(mappedBy="dishinfo", targetEntity=DishspecificationinfoEntity.class)
    @OrderBy("orderindex ASC")
    public List<DishspecificationinfoEntity> getListOfDishspecificationinfo() {
        return this.listOfDishspecificationinfo;
    }


}
