/*
 * Created on 30 五月 2015 ( Time 18:22:34 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.dt.hippo.auto.model.jpa;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.util.Date;

import javax.persistence.*;

//import com.dt.hippo.auto.model.jpa.base.AdlistEntity;
/**
 * Persistent class for entity stored in table "ADList"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="ADList", catalog="hippo" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="AdlistEntity.countAll", query="SELECT COUNT(x) FROM AdlistEntity x" )
} )
@AttributeOverrides({

})
public class AdlistEntity extends com.dt.hippo.auto.model.jpa.base.AdlistEntity implements Serializable {

   protected static final long serialVersionUID = 8L;

     //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------

}