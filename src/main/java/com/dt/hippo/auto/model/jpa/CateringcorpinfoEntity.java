/*
 * Created on 13 五月 2015 ( Time 21:15:24 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.dt.hippo.auto.model.jpa;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.util.Date;

import javax.persistence.*;

//import com.dt.hippo.auto.model.jpa.base.CateringcorpinfoEntity;
/**
 * Persistent class for entity stored in table "cateringcorpinfo"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="cateringcorpinfo", catalog="hippo" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="CateringcorpinfoEntity.countAll", query="SELECT COUNT(x) FROM CateringcorpinfoEntity x" )
} )
public class CateringcorpinfoEntity extends com.dt.hippo.auto.model.jpa.base.CateringcorpinfoEntity implements Serializable {

   protected static final long serialVersionUID = 8L;

     //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------

}