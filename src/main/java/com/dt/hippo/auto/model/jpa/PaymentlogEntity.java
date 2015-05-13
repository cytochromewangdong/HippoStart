/*
 * Created on 13 五月 2015 ( Time 21:15:28 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.dt.hippo.auto.model.jpa;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.util.Date;

import javax.persistence.*;

//import com.dt.hippo.auto.model.jpa.base.PaymentlogEntity;
/**
 * Persistent class for entity stored in table "paymentlog"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="paymentlog", catalog="hippo" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="PaymentlogEntity.countAll", query="SELECT COUNT(x) FROM PaymentlogEntity x" )
} )
public class PaymentlogEntity extends com.dt.hippo.auto.model.jpa.base.PaymentlogEntity implements Serializable {

   protected static final long serialVersionUID = 8L;

     //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------

}
