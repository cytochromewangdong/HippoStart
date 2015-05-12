/*
 * Created on 21 ���� 2014 ( Time 16:43:28 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.datajpa.business.service.impl;

import java.util.List;

import javax.annotation.Resource;

import java.util.List;

import com.dt.hippo.datajpa.business.service.HobbyService;
import com.dt.hippo.datajpa.data.repository.jpa.HobbyJpaRepository;
import com.dt.hippo.datajpa.model.jpa.Hobby;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of HobbyService
 */
@Component
@Transactional
public class HobbyServiceImpl implements HobbyService {

	@Resource
	private HobbyJpaRepository hobbyJpaRepository;

	
	@Override
    @Transactional(readOnly = true)
	public Hobby findById(String hobbyId) {
		return hobbyJpaRepository.findOne(hobbyId);
	}

	@Override
    @Transactional(readOnly = true)
	public List<Hobby> findAll() {
		return  hobbyJpaRepository.findAll();
	}

	@Override
	public Hobby save(Hobby hobby) {
		return hobbyJpaRepository.save(hobby) ;
	}

	@Override
	public Hobby create(Hobby hobby) {
		Hobby hobbyExisted = hobbyJpaRepository.findOne(hobby.getHobbyId());
		if( hobbyExisted != null ) {
			throw new IllegalStateException("already.exists");
		}
		return hobbyJpaRepository.save(hobby);
	}

	@Override
	public Hobby update(Hobby hobby) {
		Hobby hobbyExisted = hobbyJpaRepository.findOne(hobby.getHobbyId());
        if (hobbyExisted == null) {
            throw new IllegalStateException("not exists");
        }
		return hobbyJpaRepository.save(hobby);
	}

	@Override
	public void delete(String hobbyId) {
		hobbyJpaRepository.delete(hobbyId);
	}

	public HobbyJpaRepository getHobbyJpaRepository() {
		return hobbyJpaRepository;
	}

	public void setHobbyJpaRepository(HobbyJpaRepository hobbyJpaRepository) {
		this.hobbyJpaRepository = hobbyJpaRepository;
	}



}