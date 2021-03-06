/*
 * Created on 18 五月 2015 ( Time 11:07:10 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.dt.hippo.auto.model.jpa;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.util.Date;

import javax.persistence.*;

//import com.dt.hippo.auto.model.jpa.base.ComboinfoEntity;
/**
 * Persistent class for entity stored in table "comboinfo"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="comboinfo", catalog="hippo" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="ComboinfoEntity.countAll", query="SELECT COUNT(x) FROM ComboinfoEntity x" )
} )
@AttributeOverrides({
 @AttributeOverride(name = "specificationid", column = @Column(name = "specificationId", insertable = false, updatable = false))

})
public class ComboinfoEntity extends com.dt.hippo.auto.model.jpa.base.ComboinfoEntity implements Serializable {

   protected static final long serialVersionUID = 8L;

     //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    protected DishspecificationinfoEntity dishspecificationinfo;


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setDishspecificationinfo( DishspecificationinfoEntity dishspecificationinfo ) {
        this.dishspecificationinfo = dishspecificationinfo;
    }
    @ManyToOne
    @JoinColumn(name="specificationId", referencedColumnName="uid")
    public DishspecificationinfoEntity getDishspecificationinfo() {
        return this.dishspecificationinfo;
    }


}
