package com.dt.hippo.datajpa.data.repository.my;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import com.dt.hippo.datajpa.data.repository.jpa.ContactJpaRepository;
import com.dt.hippo.datajpa.model.jpa.Contact;

public interface MyContactJpaRepository extends ContactJpaRepository {
	@Cacheable("contacts")
	List<Contact> findContactByFirstNameLike(String firstName);
}
