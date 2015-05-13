/*
 * Created on 13 五月 2015 ( Time 21:15:25 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.auto.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.dt.hippo.auto.model.Dishinfo;
import com.dt.hippo.auto.model.jpa.DishinfoEntity;
import java.util.Date;
import java.util.List;
import com.dt.hippo.auto.business.service.DishinfoService;
import com.dt.hippo.auto.business.service.mapping.DishinfoServiceMapper;
import com.dt.hippo.auto.data.repository.jpa.DishinfoJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of DishinfoService
 */
@Service("dishinfoService")
@Transactional
public class DishinfoServiceImpl implements DishinfoService {

	@Resource
	protected DishinfoJpaRepository dishinfoJpaRepository;

	@Resource
	protected DishinfoServiceMapper dishinfoServiceMapper;
	
	@Override
	public Dishinfo findById(Long uid) {
		DishinfoEntity dishinfoEntity = dishinfoJpaRepository.findOne(uid);
		return dishinfoServiceMapper.mapDishinfoEntityToDishinfo(dishinfoEntity);
	}

	@Override
	public List<Dishinfo> findAll() {
		Iterable<DishinfoEntity> entities = dishinfoJpaRepository.findAll();
		List<Dishinfo> beans = new ArrayList<Dishinfo>();
		for(DishinfoEntity dishinfoEntity : entities) {
			beans.add(dishinfoServiceMapper.mapDishinfoEntityToDishinfo(dishinfoEntity));
		}
		return beans;
	}

	@Override
	public Dishinfo save(Dishinfo dishinfo) {
		return update(dishinfo) ;
	}

	@Override
	public Dishinfo create(Dishinfo dishinfo) {
		DishinfoEntity dishinfoEntity = dishinfoJpaRepository.findOne(dishinfo.getUid());
		if( dishinfoEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		dishinfoEntity = new DishinfoEntity();
		dishinfoServiceMapper.mapDishinfoToDishinfoEntity(dishinfo, dishinfoEntity);
		DishinfoEntity dishinfoEntitySaved = dishinfoJpaRepository.save(dishinfoEntity);
		return dishinfoServiceMapper.mapDishinfoEntityToDishinfo(dishinfoEntitySaved);
	}

	@Override
	public Dishinfo update(Dishinfo dishinfo) {
		DishinfoEntity dishinfoEntity = dishinfoJpaRepository.findOne(dishinfo.getUid());
		dishinfoServiceMapper.mapDishinfoToDishinfoEntity(dishinfo, dishinfoEntity);
		DishinfoEntity dishinfoEntitySaved = dishinfoJpaRepository.save(dishinfoEntity);
		return dishinfoServiceMapper.mapDishinfoEntityToDishinfo(dishinfoEntitySaved);
	}

	@Override
	public void delete(Long uid) {
		dishinfoJpaRepository.delete(uid);
	}

	public DishinfoJpaRepository getDishinfoJpaRepository() {
		return dishinfoJpaRepository;
	}

	public void setDishinfoJpaRepository(DishinfoJpaRepository dishinfoJpaRepository) {
		this.dishinfoJpaRepository = dishinfoJpaRepository;
	}

	public DishinfoServiceMapper getDishinfoServiceMapper() {
		return dishinfoServiceMapper;
	}

	public void setDishinfoServiceMapper(DishinfoServiceMapper dishinfoServiceMapper) {
		this.dishinfoServiceMapper = dishinfoServiceMapper;
	}

}