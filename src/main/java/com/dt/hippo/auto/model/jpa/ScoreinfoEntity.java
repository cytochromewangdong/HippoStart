/*
 * Created on 18 五月 2015 ( Time 11:07:16 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.dt.hippo.auto.model.jpa;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.util.Date;

import javax.persistence.*;

//import com.dt.hippo.auto.model.jpa.base.ScoreinfoEntity;
/**
 * Persistent class for entity stored in table "scoreinfo"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="scoreinfo", catalog="hippo" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="ScoreinfoEntity.countAll", query="SELECT COUNT(x) FROM ScoreinfoEntity x" )
} )
@AttributeOverrides({

})
public class ScoreinfoEntity extends com.dt.hippo.auto.model.jpa.base.ScoreinfoEntity implements Serializable {

   protected static final long serialVersionUID = 8L;

     //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------

}
