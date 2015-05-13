/*
 * Created on 13 五月 2015 ( Time 21:15:29 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.auto.business.service;

import java.util.List;

import com.dt.hippo.auto.model.Pointrule;

/**
 * Business Service Interface for entity Pointrule.
 */
public interface PointruleService { 

	/**
	 * Loads an entity from the database using its Primary Key
	 * @param type
	 * @return entity
	 */
	Pointrule findById( Byte type  ) ;

	/**
	 * Loads all entities.
	 * @return all entities
	 */
	List<Pointrule> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	Pointrule save(Pointrule entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return
	 */
	Pointrule update(Pointrule entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	Pointrule create(Pointrule entity);

	/**
	 * Deletes an entity using its Primary Key
	 * @param type
	 */
	void delete( Byte type );


}