/*
 * Created on 18 五月 2015 ( Time 11:07:20 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.auto.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.dt.hippo.auto.model.Vouchergeneratorinfo;
import com.dt.hippo.auto.model.jpa.VouchergeneratorinfoEntity;
import com.dt.hippo.auto.model.jpa.VouchergeneratorinfoEntityKey;
import java.util.Date;
import com.dt.hippo.auto.business.service.VouchergeneratorinfoService;
import com.dt.hippo.auto.business.service.mapping.VouchergeneratorinfoServiceMapper;
import com.dt.hippo.auto.data.repository.jpa.VouchergeneratorinfoJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of VouchergeneratorinfoService
 */
@Service("vouchergeneratorinfoService")
@Transactional
public class VouchergeneratorinfoServiceImpl implements VouchergeneratorinfoService {

	@Resource
	protected VouchergeneratorinfoJpaRepository vouchergeneratorinfoJpaRepository;

	@Resource
	protected VouchergeneratorinfoServiceMapper vouchergeneratorinfoServiceMapper;
	
	@Override
	public Vouchergeneratorinfo findById(Integer uid, Integer value) {
		VouchergeneratorinfoEntityKey id = new VouchergeneratorinfoEntityKey(uid, value);
		VouchergeneratorinfoEntity vouchergeneratorinfoEntity = vouchergeneratorinfoJpaRepository.findOne(id);
		return vouchergeneratorinfoServiceMapper.mapVouchergeneratorinfoEntityToVouchergeneratorinfo(vouchergeneratorinfoEntity);
	}

	@Override
	public List<Vouchergeneratorinfo> findAll() {
		Iterable<VouchergeneratorinfoEntity> entities = vouchergeneratorinfoJpaRepository.findAll();
		List<Vouchergeneratorinfo> beans = new ArrayList<Vouchergeneratorinfo>();
		for(VouchergeneratorinfoEntity vouchergeneratorinfoEntity : entities) {
			beans.add(vouchergeneratorinfoServiceMapper.mapVouchergeneratorinfoEntityToVouchergeneratorinfo(vouchergeneratorinfoEntity));
		}
		return beans;
	}

	@Override
	public Vouchergeneratorinfo save(Vouchergeneratorinfo vouchergeneratorinfo) {
		return update(vouchergeneratorinfo) ;
	}

	@Override
	public Vouchergeneratorinfo create(Vouchergeneratorinfo vouchergeneratorinfo) {
//		VouchergeneratorinfoEntityKey id = new VouchergeneratorinfoEntityKey(vouchergeneratorinfo.getUid(), vouchergeneratorinfo.getValue());
//		VouchergeneratorinfoEntity vouchergeneratorinfoEntity = vouchergeneratorinfoJpaRepository.findOne(id);
//		if( vouchergeneratorinfoEntity != null ) {
//			throw new IllegalStateException("already.exists");
//		}
		VouchergeneratorinfoEntity vouchergeneratorinfoEntity = new VouchergeneratorinfoEntity();
		vouchergeneratorinfoServiceMapper.mapVouchergeneratorinfoToVouchergeneratorinfoEntity(vouchergeneratorinfo, vouchergeneratorinfoEntity);
		VouchergeneratorinfoEntity vouchergeneratorinfoEntitySaved = vouchergeneratorinfoJpaRepository.save(vouchergeneratorinfoEntity);
		return vouchergeneratorinfoServiceMapper.mapVouchergeneratorinfoEntityToVouchergeneratorinfo(vouchergeneratorinfoEntitySaved);
	}

	@Override
	public Vouchergeneratorinfo update(Vouchergeneratorinfo vouchergeneratorinfo) {
		VouchergeneratorinfoEntityKey id = new VouchergeneratorinfoEntityKey(vouchergeneratorinfo.getUid(), vouchergeneratorinfo.getValue());
		VouchergeneratorinfoEntity vouchergeneratorinfoEntity = vouchergeneratorinfoJpaRepository.findOne(id);
		vouchergeneratorinfoServiceMapper.mapVouchergeneratorinfoToVouchergeneratorinfoEntity(vouchergeneratorinfo, vouchergeneratorinfoEntity);
		VouchergeneratorinfoEntity vouchergeneratorinfoEntitySaved = vouchergeneratorinfoJpaRepository.save(vouchergeneratorinfoEntity);
		return vouchergeneratorinfoServiceMapper.mapVouchergeneratorinfoEntityToVouchergeneratorinfo(vouchergeneratorinfoEntitySaved);
	}

	@Override
	public void delete(Integer uid, Integer value) {
		VouchergeneratorinfoEntityKey id = new VouchergeneratorinfoEntityKey(uid, value);
		vouchergeneratorinfoJpaRepository.delete(id);
	}

	public VouchergeneratorinfoJpaRepository getVouchergeneratorinfoJpaRepository() {
		return vouchergeneratorinfoJpaRepository;
	}

	public void setVouchergeneratorinfoJpaRepository(VouchergeneratorinfoJpaRepository vouchergeneratorinfoJpaRepository) {
		this.vouchergeneratorinfoJpaRepository = vouchergeneratorinfoJpaRepository;
	}

	public VouchergeneratorinfoServiceMapper getVouchergeneratorinfoServiceMapper() {
		return vouchergeneratorinfoServiceMapper;
	}

	public void setVouchergeneratorinfoServiceMapper(VouchergeneratorinfoServiceMapper vouchergeneratorinfoServiceMapper) {
		this.vouchergeneratorinfoServiceMapper = vouchergeneratorinfoServiceMapper;
	}

}
