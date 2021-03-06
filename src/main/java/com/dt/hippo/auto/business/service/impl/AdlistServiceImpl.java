/*
 * Created on 30 五月 2015 ( Time 18:22:33 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.auto.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.dt.hippo.auto.model.Adlist;
import com.dt.hippo.auto.model.jpa.AdlistEntity;
import java.util.Date;
import com.dt.hippo.auto.business.service.AdlistService;
import com.dt.hippo.auto.business.service.mapping.AdlistServiceMapper;
import com.dt.hippo.auto.data.repository.jpa.AdlistJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of AdlistService
 */
@Service("adlistService")
@Transactional
public class AdlistServiceImpl implements AdlistService {

	@Resource
	protected AdlistJpaRepository adlistJpaRepository;

	@Resource
	protected AdlistServiceMapper adlistServiceMapper;
	
	@Override
	public Adlist findById(Long uid) {
		AdlistEntity adlistEntity = adlistJpaRepository.findOne(uid);
		return adlistServiceMapper.mapAdlistEntityToAdlist(adlistEntity);
	}

	@Override
	public List<Adlist> findAll() {
		Iterable<AdlistEntity> entities = adlistJpaRepository.findAll();
		List<Adlist> beans = new ArrayList<Adlist>();
		for(AdlistEntity adlistEntity : entities) {
			beans.add(adlistServiceMapper.mapAdlistEntityToAdlist(adlistEntity));
		}
		return beans;
	}

	@Override
	public Adlist save(Adlist adlist) {
		return update(adlist) ;
	}

	@Override
	public Adlist create(Adlist adlist) {
//		AdlistEntity adlistEntity = adlistJpaRepository.findOne(adlist.getUid());
//		if( adlistEntity != null ) {
//			throw new IllegalStateException("already.exists");
//		}
		AdlistEntity adlistEntity = new AdlistEntity();
		adlistServiceMapper.mapAdlistToAdlistEntity(adlist, adlistEntity);
		AdlistEntity adlistEntitySaved = adlistJpaRepository.save(adlistEntity);
		return adlistServiceMapper.mapAdlistEntityToAdlist(adlistEntitySaved);
	}

	@Override
	public Adlist update(Adlist adlist) {
		AdlistEntity adlistEntity = adlistJpaRepository.findOne(adlist.getUid());
		adlistServiceMapper.mapAdlistToAdlistEntity(adlist, adlistEntity);
		AdlistEntity adlistEntitySaved = adlistJpaRepository.save(adlistEntity);
		return adlistServiceMapper.mapAdlistEntityToAdlist(adlistEntitySaved);
	}

	@Override
	public void delete(Long uid) {
		adlistJpaRepository.delete(uid);
	}

	public AdlistJpaRepository getAdlistJpaRepository() {
		return adlistJpaRepository;
	}

	public void setAdlistJpaRepository(AdlistJpaRepository adlistJpaRepository) {
		this.adlistJpaRepository = adlistJpaRepository;
	}

	public AdlistServiceMapper getAdlistServiceMapper() {
		return adlistServiceMapper;
	}

	public void setAdlistServiceMapper(AdlistServiceMapper adlistServiceMapper) {
		this.adlistServiceMapper = adlistServiceMapper;
	}

}
