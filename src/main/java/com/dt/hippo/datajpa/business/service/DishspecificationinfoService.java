/*
 * Created on 10 五月 2015 ( Time 22:14:59 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.datajpa.business.service;

import java.util.List;

import com.dt.hippo.datajpa.model.jpa.Dishspecificationinfo;

/**
 * Business Service Interface for entity Dishspecificationinfo.
 */
public interface DishspecificationinfoService { 

	/**
	 * Loads an entity from the database using its Primary Key
	 * @param dishid
	 * @param uid
	 * @return entity
	 */
	Dishspecificationinfo findById( Long dishid, Long uid  ) ;

	/**
	 * Loads all entities.
	 * @return all entities
	 */
	List<Dishspecificationinfo> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	Dishspecificationinfo save(Dishspecificationinfo entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return
	 */
	Dishspecificationinfo update(Dishspecificationinfo entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	Dishspecificationinfo create(Dishspecificationinfo entity);

	/**
	 * Deletes an entity using its Primary Key
	 * @param dishid
	 * @param uid
	 */
	void delete( Long dishid, Long uid );


}
