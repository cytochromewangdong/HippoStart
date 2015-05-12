/*
 * Created on 11 五月 2015 ( Time 23:06:08 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.datajpa.business.service;

import java.util.List;

import com.dt.hippo.datajpa.model.jpa.Dishinfo;

/**
 * Business Service Interface for entity Dishinfo.
 */
public interface DishinfoService { 

	/**
	 * Loads an entity from the database using its Primary Key
	 * @param uid
	 * @return entity
	 */
	Dishinfo findById( Long uid  ) ;

	/**
	 * Loads all entities.
	 * @return all entities
	 */
	List<Dishinfo> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	Dishinfo save(Dishinfo entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return
	 */
	Dishinfo update(Dishinfo entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	Dishinfo create(Dishinfo entity);

	/**
	 * Deletes an entity using its Primary Key
	 * @param uid
	 */
	void delete( Long uid );


}
