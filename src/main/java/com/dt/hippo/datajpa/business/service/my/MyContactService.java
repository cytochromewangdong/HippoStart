package com.dt.hippo.datajpa.business.service.my;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import com.dt.hippo.datajpa.business.service.ContactService;
import com.dt.hippo.datajpa.model.jpa.Contact;

public interface MyContactService extends ContactService {
	
	List<Contact> findContactByFirstName(String firstName);
}
