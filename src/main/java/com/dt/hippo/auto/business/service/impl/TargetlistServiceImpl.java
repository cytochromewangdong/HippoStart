/*
 * Created on 21 五月 2015 ( Time 16:17:16 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.auto.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.dt.hippo.auto.model.Targetlist;
import com.dt.hippo.auto.model.jpa.TargetlistEntity;
import java.util.Date;
import com.dt.hippo.auto.business.service.TargetlistService;
import com.dt.hippo.auto.business.service.mapping.TargetlistServiceMapper;
import com.dt.hippo.auto.data.repository.jpa.TargetlistJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of TargetlistService
 */
@Service("targetlistService")
@Transactional
public class TargetlistServiceImpl implements TargetlistService {

	@Resource
	protected TargetlistJpaRepository targetlistJpaRepository;

	@Resource
	protected TargetlistServiceMapper targetlistServiceMapper;
	
	@Override
	public Targetlist findById(Long uid) {
		TargetlistEntity targetlistEntity = targetlistJpaRepository.findOne(uid);
		return targetlistServiceMapper.mapTargetlistEntityToTargetlist(targetlistEntity);
	}

	@Override
	public List<Targetlist> findAll() {
		Iterable<TargetlistEntity> entities = targetlistJpaRepository.findAll();
		List<Targetlist> beans = new ArrayList<Targetlist>();
		for(TargetlistEntity targetlistEntity : entities) {
			beans.add(targetlistServiceMapper.mapTargetlistEntityToTargetlist(targetlistEntity));
		}
		return beans;
	}

	@Override
	public Targetlist save(Targetlist targetlist) {
		return update(targetlist) ;
	}

	@Override
	public Targetlist create(Targetlist targetlist) {
//		TargetlistEntity targetlistEntity = targetlistJpaRepository.findOne(targetlist.getUid());
//		if( targetlistEntity != null ) {
//			throw new IllegalStateException("already.exists");
//		}
		TargetlistEntity targetlistEntity = new TargetlistEntity();
		targetlistServiceMapper.mapTargetlistToTargetlistEntity(targetlist, targetlistEntity);
		TargetlistEntity targetlistEntitySaved = targetlistJpaRepository.save(targetlistEntity);
		return targetlistServiceMapper.mapTargetlistEntityToTargetlist(targetlistEntitySaved);
	}

	@Override
	public Targetlist update(Targetlist targetlist) {
		TargetlistEntity targetlistEntity = targetlistJpaRepository.findOne(targetlist.getUid());
		targetlistServiceMapper.mapTargetlistToTargetlistEntity(targetlist, targetlistEntity);
		TargetlistEntity targetlistEntitySaved = targetlistJpaRepository.save(targetlistEntity);
		return targetlistServiceMapper.mapTargetlistEntityToTargetlist(targetlistEntitySaved);
	}

	@Override
	public void delete(Long uid) {
		targetlistJpaRepository.delete(uid);
	}

	public TargetlistJpaRepository getTargetlistJpaRepository() {
		return targetlistJpaRepository;
	}

	public void setTargetlistJpaRepository(TargetlistJpaRepository targetlistJpaRepository) {
		this.targetlistJpaRepository = targetlistJpaRepository;
	}

	public TargetlistServiceMapper getTargetlistServiceMapper() {
		return targetlistServiceMapper;
	}

	public void setTargetlistServiceMapper(TargetlistServiceMapper targetlistServiceMapper) {
		this.targetlistServiceMapper = targetlistServiceMapper;
	}

}
