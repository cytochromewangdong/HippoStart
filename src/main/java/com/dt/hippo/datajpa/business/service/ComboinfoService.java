/*
 * Created on 11 五月 2015 ( Time 23:06:06 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.datajpa.business.service;

import java.util.List;

import com.dt.hippo.datajpa.model.jpa.Comboinfo;

/**
 * Business Service Interface for entity Comboinfo.
 */
public interface ComboinfoService { 

	/**
	 * Loads an entity from the database using its Primary Key
	 * @param uid
	 * @param childid
	 * @param specificationid
	 * @return entity
	 */
	Comboinfo findById( Long uid, Long childid, Long specificationid  ) ;

	/**
	 * Loads all entities.
	 * @return all entities
	 */
	List<Comboinfo> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	Comboinfo save(Comboinfo entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return
	 */
	Comboinfo update(Comboinfo entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	Comboinfo create(Comboinfo entity);

	/**
	 * Deletes an entity using its Primary Key
	 * @param uid
	 * @param childid
	 * @param specificationid
	 */
	void delete( Long uid, Long childid, Long specificationid );


}
