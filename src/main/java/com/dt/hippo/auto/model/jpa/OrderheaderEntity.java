/*
 * Created on 18 五月 2015 ( Time 11:07:13 )
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

//import com.dt.hippo.auto.model.jpa.base.OrderheaderEntity;
/**
 * Persistent class for entity stored in table "orderheader"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="orderheader", catalog="hippo" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="OrderheaderEntity.countAll", query="SELECT COUNT(x) FROM OrderheaderEntity x" )
} )
@AttributeOverrides({

})
public class OrderheaderEntity extends com.dt.hippo.auto.model.jpa.base.OrderheaderEntity implements Serializable {

   protected static final long serialVersionUID = 8L;

     //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
	protected List<OrderdetailEntity> listOfOrderdetail;

	@OneToMany
	@JoinColumn(name = "orderuid", referencedColumnName = "uid")
	public List<OrderdetailEntity> getListOfOrderdetail()
	{
		return listOfOrderdetail;
	}

	public void setListOfOrderdetail(
			List<OrderdetailEntity> listOfOrderdetail)
	{
		this.listOfOrderdetail = listOfOrderdetail;
	}


}
