/*
 * Created on 18 五月 2015 ( Time 11:07:18 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.dt.hippo.auto.model.jpa;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;


import javax.persistence.*;

//import com.dt.hippo.auto.model.jpa.base.SystemparameterEntity;
/**
 * Persistent class for entity stored in table "systemparameter"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="systemparameter", catalog="hippo" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="SystemparameterEntity.countAll", query="SELECT COUNT(x) FROM SystemparameterEntity x" )
} )
@AttributeOverrides({

})
public class SystemparameterEntity extends com.dt.hippo.auto.model.jpa.base.SystemparameterEntity implements Serializable {

   protected static final long serialVersionUID = 8L;

     //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------

}
