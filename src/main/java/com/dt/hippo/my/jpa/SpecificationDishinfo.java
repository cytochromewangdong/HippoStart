package com.dt.hippo.my.jpa;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.dt.hippo.auto.model.jpa.DishinfoEntity;

@Entity
@DiscriminatorValue("0")
public class SpecificationDishinfo extends DishinfoEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8324836249373785625L;


	
}
