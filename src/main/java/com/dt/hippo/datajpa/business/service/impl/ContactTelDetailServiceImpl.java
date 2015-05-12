/*
 * Created on 21 ���� 2014 ( Time 16:43:28 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.datajpa.business.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.dt.hippo.datajpa.business.service.ContactTelDetailService;
import com.dt.hippo.datajpa.data.repository.jpa.ContactTelDetailJpaRepository;
import com.dt.hippo.datajpa.model.jpa.ContactTelDetail;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of ContactTelDetailService
 */
@Component
@Transactional
public class ContactTelDetailServiceImpl implements ContactTelDetailService {

	@Resource
	private ContactTelDetailJpaRepository contactTelDetailJpaRepository;

	
	@Override
    @Transactional(readOnly = true)
	public ContactTelDetail findById(Integer id) {
		return contactTelDetailJpaRepository.findOne(id);
	}

	@Override
    @Transactional(readOnly = true)
	public List<ContactTelDetail> findAll() {
		return  contactTelDetailJpaRepository.findAll();
	}

	@Override
	public ContactTelDetail save(ContactTelDetail contactTelDetail) {
		return contactTelDetailJpaRepository.save(contactTelDetail) ;
	}

	@Override
	public ContactTelDetail create(ContactTelDetail contactTelDetail) {
		ContactTelDetail contactTelDetailExisted = contactTelDetailJpaRepository.findOne(contactTelDetail.getId());
		if( contactTelDetailExisted != null ) {
			throw new IllegalStateException("already.exists");
		}
		return contactTelDetailJpaRepository.save(contactTelDetail);
	}

	@Override
	public ContactTelDetail update(ContactTelDetail contactTelDetail) {
		ContactTelDetail contactTelDetailExisted = contactTelDetailJpaRepository.findOne(contactTelDetail.getId());
        if (contactTelDetailExisted == null) {
            throw new IllegalStateException("not exists");
        }
		return contactTelDetailJpaRepository.save(contactTelDetail);
	}

	@Override
	public void delete(Integer id) {
		contactTelDetailJpaRepository.delete(id);
	}

	public ContactTelDetailJpaRepository getContactTelDetailJpaRepository() {
		return contactTelDetailJpaRepository;
	}

	public void setContactTelDetailJpaRepository(ContactTelDetailJpaRepository contactTelDetailJpaRepository) {
		this.contactTelDetailJpaRepository = contactTelDetailJpaRepository;
	}



}