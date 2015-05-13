/*
 * Created on 13 五月 2015 ( Time 21:15:32 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.auto.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.dt.hippo.auto.model.Verifyrecord;
import com.dt.hippo.auto.model.jpa.VerifyrecordEntity;
import java.util.Date;
import com.dt.hippo.auto.business.service.VerifyrecordService;
import com.dt.hippo.auto.business.service.mapping.VerifyrecordServiceMapper;
import com.dt.hippo.auto.data.repository.jpa.VerifyrecordJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of VerifyrecordService
 */
@Service("verifyrecordService")
@Transactional
public class VerifyrecordServiceImpl implements VerifyrecordService {

	@Resource
	protected VerifyrecordJpaRepository verifyrecordJpaRepository;

	@Resource
	protected VerifyrecordServiceMapper verifyrecordServiceMapper;
	
	@Override
	public Verifyrecord findById(Long uid) {
		VerifyrecordEntity verifyrecordEntity = verifyrecordJpaRepository.findOne(uid);
		return verifyrecordServiceMapper.mapVerifyrecordEntityToVerifyrecord(verifyrecordEntity);
	}

	@Override
	public List<Verifyrecord> findAll() {
		Iterable<VerifyrecordEntity> entities = verifyrecordJpaRepository.findAll();
		List<Verifyrecord> beans = new ArrayList<Verifyrecord>();
		for(VerifyrecordEntity verifyrecordEntity : entities) {
			beans.add(verifyrecordServiceMapper.mapVerifyrecordEntityToVerifyrecord(verifyrecordEntity));
		}
		return beans;
	}

	@Override
	public Verifyrecord save(Verifyrecord verifyrecord) {
		return update(verifyrecord) ;
	}

	@Override
	public Verifyrecord create(Verifyrecord verifyrecord) {
		VerifyrecordEntity verifyrecordEntity = verifyrecordJpaRepository.findOne(verifyrecord.getUid());
		if( verifyrecordEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		verifyrecordEntity = new VerifyrecordEntity();
		verifyrecordServiceMapper.mapVerifyrecordToVerifyrecordEntity(verifyrecord, verifyrecordEntity);
		VerifyrecordEntity verifyrecordEntitySaved = verifyrecordJpaRepository.save(verifyrecordEntity);
		return verifyrecordServiceMapper.mapVerifyrecordEntityToVerifyrecord(verifyrecordEntitySaved);
	}

	@Override
	public Verifyrecord update(Verifyrecord verifyrecord) {
		VerifyrecordEntity verifyrecordEntity = verifyrecordJpaRepository.findOne(verifyrecord.getUid());
		verifyrecordServiceMapper.mapVerifyrecordToVerifyrecordEntity(verifyrecord, verifyrecordEntity);
		VerifyrecordEntity verifyrecordEntitySaved = verifyrecordJpaRepository.save(verifyrecordEntity);
		return verifyrecordServiceMapper.mapVerifyrecordEntityToVerifyrecord(verifyrecordEntitySaved);
	}

	@Override
	public void delete(Long uid) {
		verifyrecordJpaRepository.delete(uid);
	}

	public VerifyrecordJpaRepository getVerifyrecordJpaRepository() {
		return verifyrecordJpaRepository;
	}

	public void setVerifyrecordJpaRepository(VerifyrecordJpaRepository verifyrecordJpaRepository) {
		this.verifyrecordJpaRepository = verifyrecordJpaRepository;
	}

	public VerifyrecordServiceMapper getVerifyrecordServiceMapper() {
		return verifyrecordServiceMapper;
	}

	public void setVerifyrecordServiceMapper(VerifyrecordServiceMapper verifyrecordServiceMapper) {
		this.verifyrecordServiceMapper = verifyrecordServiceMapper;
	}

}
