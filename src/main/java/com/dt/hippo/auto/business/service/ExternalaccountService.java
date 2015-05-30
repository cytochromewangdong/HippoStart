/*
 * Created on 30 五月 2015 ( Time 21:07:38 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.auto.business.service;

import java.util.List;

import com.dt.hippo.auto.model.Externalaccount;

/**
 * Business Service Interface for entity Externalaccount.
 */
public interface ExternalaccountService { 

	/**
	 * Loads an entity from the database using its Primary Key
	 * @param uid
	 * @return entity
	 */
	Externalaccount findById( Long uid  ) ;

	/**
	 * Loads all entities.
	 * @return all entities
	 */
	List<Externalaccount> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	Externalaccount save(Externalaccount entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return
	 */
	Externalaccount update(Externalaccount entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	Externalaccount create(Externalaccount entity);

	/**
	 * Deletes an entity using its Primary Key
	 * @param uid
	 */
	void delete( Long uid );


}
