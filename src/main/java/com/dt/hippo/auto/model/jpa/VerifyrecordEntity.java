/*
 * Created on 14 五月 2015 ( Time 21:14:05 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.dt.hippo.auto.model.jpa;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.util.Date;

import javax.persistence.*;

//import com.dt.hippo.auto.model.jpa.base.VerifyrecordEntity;
/**
 * Persistent class for entity stored in table "verifyrecord"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="verifyrecord", catalog="hippo" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="VerifyrecordEntity.countAll", query="SELECT COUNT(x) FROM VerifyrecordEntity x" )
} )
@AttributeOverrides({

})
public class VerifyrecordEntity extends com.dt.hippo.auto.model.jpa.base.VerifyrecordEntity implements Serializable {

   protected static final long serialVersionUID = 8L;

     //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------

}
