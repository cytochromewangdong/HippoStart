package com.dt.hippo.datajpa.data.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dt.hippo.datajpa.model.jpa.Contact;

/**
 * Repository : Contact.
 */
public interface ContactJpaRepository extends JpaRepository<Contact, Integer> {

}
