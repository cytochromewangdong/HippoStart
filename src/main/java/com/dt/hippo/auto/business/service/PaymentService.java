/*
 * Created on 13 五月 2015 ( Time 21:15:28 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.auto.business.service;

import java.util.List;

import com.dt.hippo.auto.model.Payment;

/**
 * Business Service Interface for entity Payment.
 */
public interface PaymentService { 

	/**
	 * Loads an entity from the database using its Primary Key
	 * @param uid
	 * @return entity
	 */
	Payment findById( Long uid  ) ;

	/**
	 * Loads all entities.
	 * @return all entities
	 */
	List<Payment> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	Payment save(Payment entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return
	 */
	Payment update(Payment entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	Payment create(Payment entity);

	/**
	 * Deletes an entity using its Primary Key
	 * @param uid
	 */
	void delete( Long uid );


}