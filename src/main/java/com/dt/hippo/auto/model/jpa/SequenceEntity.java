/*
 * Created on 18 五月 2015 ( Time 11:47:30 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
// This Bean has a composite Primary Key  


package com.dt.hippo.auto.model.jpa;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;


import javax.persistence.*;

//import com.dt.hippo.auto.model.jpa.base.SequenceEntity;
/**
 * Persistent class for entity stored in table "sequence"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="sequence", catalog="hippo" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="SequenceEntity.countAll", query="SELECT COUNT(x) FROM SequenceEntity x" )
} )
@AttributeOverrides({

})
public class SequenceEntity extends com.dt.hippo.auto.model.jpa.base.SequenceEntity implements Serializable {

   protected static final long serialVersionUID = 8L;

     //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------

}
