/*
 * Created on 13 五月 2015 ( Time 21:15:33 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.auto.business.service;

import java.util.List;

import com.dt.hippo.auto.model.Vouchergeneratorinfo;

/**
 * Business Service Interface for entity Vouchergeneratorinfo.
 */
public interface VouchergeneratorinfoService { 

	/**
	 * Loads an entity from the database using its Primary Key
	 * @param uid
	 * @return entity
	 */
	Vouchergeneratorinfo findById( Long uid  ) ;

	/**
	 * Loads all entities.
	 * @return all entities
	 */
	List<Vouchergeneratorinfo> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	Vouchergeneratorinfo save(Vouchergeneratorinfo entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return
	 */
	Vouchergeneratorinfo update(Vouchergeneratorinfo entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	Vouchergeneratorinfo create(Vouchergeneratorinfo entity);

	/**
	 * Deletes an entity using its Primary Key
	 * @param uid
	 */
	void delete( Long uid );


}