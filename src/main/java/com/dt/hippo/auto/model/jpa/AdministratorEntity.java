/*
 * Created on 18 五月 2015 ( Time 11:07:08 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.dt.hippo.auto.model.jpa;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.util.Date;

import javax.persistence.*;

//import com.dt.hippo.auto.model.jpa.base.AdministratorEntity;
/**
 * Persistent class for entity stored in table "administrator"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="administrator", catalog="hippo" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="AdministratorEntity.countAll", query="SELECT COUNT(x) FROM AdministratorEntity x" )
} )
@AttributeOverrides({

})
public class AdministratorEntity extends com.dt.hippo.auto.model.jpa.base.AdministratorEntity implements Serializable {

   protected static final long serialVersionUID = 8L;

     //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------

}
