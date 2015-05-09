package com.dt.hippo.datajpa.business.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dt.hippo.datajpa.business.service.my.MyContactService;
import com.dt.hippo.datajpa.data.repository.my.MyContactJpaRepository;
import com.dt.hippo.datajpa.model.jpa.Contact;

@Service
@Transactional
public class MyContactServiceImpl extends ContactServiceImpl implements MyContactService {

	@Resource
	private MyContactJpaRepository myContactJpaRepository;
	
	
    @Transactional(readOnly = true)
	public List<Contact> findContactByFirstName(String firstName)
	{
    	List<Contact> contactList = myContactJpaRepository.findContactByFirstNameLike(firstName);
    	for(Contact c:contactList)
    	{
    		c.getListOfHobby().size();
    		c.getListOfContactTelDetail().size();
    	}
    	return contactList;
	}
}
