/*
 * Created on 12 五月 2015 ( Time 20:53:01 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.auto.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.dt.hippo.auto.model.Comboinfo;
import com.dt.hippo.auto.model.jpa.ComboinfoEntity;
import com.dt.hippo.auto.model.jpa.ComboinfoEntityKey;
import java.util.Date;
import com.dt.hippo.auto.business.service.ComboinfoService;
import com.dt.hippo.auto.business.service.mapping.ComboinfoServiceMapper;
import com.dt.hippo.auto.data.repository.jpa.ComboinfoJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of ComboinfoService
 */
@Service("comboinfoService")
@Transactional
public class ComboinfoServiceImpl implements ComboinfoService {

	@Resource
	protected ComboinfoJpaRepository comboinfoJpaRepository;

	@Resource
	protected ComboinfoServiceMapper comboinfoServiceMapper;
	
	@Override
	public Comboinfo findById(Long uid, Long childid, Long specificationid) {
		ComboinfoEntityKey id = new ComboinfoEntityKey(uid, childid, specificationid);
		ComboinfoEntity comboinfoEntity = comboinfoJpaRepository.findOne(id);
		return comboinfoServiceMapper.mapComboinfoEntityToComboinfo(comboinfoEntity);
	}

	@Override
	public List<Comboinfo> findAll() {
		Iterable<ComboinfoEntity> entities = comboinfoJpaRepository.findAll();
		List<Comboinfo> beans = new ArrayList<Comboinfo>();
		for(ComboinfoEntity comboinfoEntity : entities) {
			beans.add(comboinfoServiceMapper.mapComboinfoEntityToComboinfo(comboinfoEntity));
		}
		return beans;
	}

	@Override
	public Comboinfo save(Comboinfo comboinfo) {
		return update(comboinfo) ;
	}

	@Override
	public Comboinfo create(Comboinfo comboinfo) {
		ComboinfoEntityKey id = new ComboinfoEntityKey(comboinfo.getUid(), comboinfo.getChildid(), comboinfo.getSpecificationid());
		ComboinfoEntity comboinfoEntity = comboinfoJpaRepository.findOne(id);
		if( comboinfoEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		comboinfoEntity = new ComboinfoEntity();
		comboinfoServiceMapper.mapComboinfoToComboinfoEntity(comboinfo, comboinfoEntity);
		ComboinfoEntity comboinfoEntitySaved = comboinfoJpaRepository.save(comboinfoEntity);
		return comboinfoServiceMapper.mapComboinfoEntityToComboinfo(comboinfoEntitySaved);
	}

	@Override
	public Comboinfo update(Comboinfo comboinfo) {
		ComboinfoEntityKey id = new ComboinfoEntityKey(comboinfo.getUid(), comboinfo.getChildid(), comboinfo.getSpecificationid());
		ComboinfoEntity comboinfoEntity = comboinfoJpaRepository.findOne(id);
		comboinfoServiceMapper.mapComboinfoToComboinfoEntity(comboinfo, comboinfoEntity);
		ComboinfoEntity comboinfoEntitySaved = comboinfoJpaRepository.save(comboinfoEntity);
		return comboinfoServiceMapper.mapComboinfoEntityToComboinfo(comboinfoEntitySaved);
	}

	@Override
	public void delete(Long uid, Long childid, Long specificationid) {
		ComboinfoEntityKey id = new ComboinfoEntityKey(uid, childid, specificationid);
		comboinfoJpaRepository.delete(id);
	}

	public ComboinfoJpaRepository getComboinfoJpaRepository() {
		return comboinfoJpaRepository;
	}

	public void setComboinfoJpaRepository(ComboinfoJpaRepository comboinfoJpaRepository) {
		this.comboinfoJpaRepository = comboinfoJpaRepository;
	}

	public ComboinfoServiceMapper getComboinfoServiceMapper() {
		return comboinfoServiceMapper;
	}

	public void setComboinfoServiceMapper(ComboinfoServiceMapper comboinfoServiceMapper) {
		this.comboinfoServiceMapper = comboinfoServiceMapper;
	}

}
