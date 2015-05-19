/*
 * Created on 18 五月 2015 ( Time 11:07:09 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.auto.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.dt.hippo.auto.model.Cateringcorpinfo;
import com.dt.hippo.auto.model.jpa.CateringcorpinfoEntity;
import java.util.Date;
import com.dt.hippo.auto.business.service.CateringcorpinfoService;
import com.dt.hippo.auto.business.service.mapping.CateringcorpinfoServiceMapper;
import com.dt.hippo.auto.data.repository.jpa.CateringcorpinfoJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of CateringcorpinfoService
 */
@Service("cateringcorpinfoService")
@Transactional
public class CateringcorpinfoServiceImpl implements CateringcorpinfoService {

	@Resource
	protected CateringcorpinfoJpaRepository cateringcorpinfoJpaRepository;

	@Resource
	protected CateringcorpinfoServiceMapper cateringcorpinfoServiceMapper;
	
	@Override
	public Cateringcorpinfo findById(Long uid) {
		CateringcorpinfoEntity cateringcorpinfoEntity = cateringcorpinfoJpaRepository.findOne(uid);
		return cateringcorpinfoServiceMapper.mapCateringcorpinfoEntityToCateringcorpinfo(cateringcorpinfoEntity);
	}

	@Override
	public List<Cateringcorpinfo> findAll() {
		Iterable<CateringcorpinfoEntity> entities = cateringcorpinfoJpaRepository.findAll();
		List<Cateringcorpinfo> beans = new ArrayList<Cateringcorpinfo>();
		for(CateringcorpinfoEntity cateringcorpinfoEntity : entities) {
			beans.add(cateringcorpinfoServiceMapper.mapCateringcorpinfoEntityToCateringcorpinfo(cateringcorpinfoEntity));
		}
		return beans;
	}

	@Override
	public Cateringcorpinfo save(Cateringcorpinfo cateringcorpinfo) {
		return update(cateringcorpinfo) ;
	}

	@Override
	public Cateringcorpinfo create(Cateringcorpinfo cateringcorpinfo) {
//		CateringcorpinfoEntity cateringcorpinfoEntity = cateringcorpinfoJpaRepository.findOne(cateringcorpinfo.getUid());
//		if( cateringcorpinfoEntity != null ) {
//			throw new IllegalStateException("already.exists");
//		}
		CateringcorpinfoEntity cateringcorpinfoEntity = new CateringcorpinfoEntity();
		cateringcorpinfoServiceMapper.mapCateringcorpinfoToCateringcorpinfoEntity(cateringcorpinfo, cateringcorpinfoEntity);
		CateringcorpinfoEntity cateringcorpinfoEntitySaved = cateringcorpinfoJpaRepository.save(cateringcorpinfoEntity);
		return cateringcorpinfoServiceMapper.mapCateringcorpinfoEntityToCateringcorpinfo(cateringcorpinfoEntitySaved);
	}

	@Override
	public Cateringcorpinfo update(Cateringcorpinfo cateringcorpinfo) {
		CateringcorpinfoEntity cateringcorpinfoEntity = cateringcorpinfoJpaRepository.findOne(cateringcorpinfo.getUid());
		cateringcorpinfoServiceMapper.mapCateringcorpinfoToCateringcorpinfoEntity(cateringcorpinfo, cateringcorpinfoEntity);
		CateringcorpinfoEntity cateringcorpinfoEntitySaved = cateringcorpinfoJpaRepository.save(cateringcorpinfoEntity);
		return cateringcorpinfoServiceMapper.mapCateringcorpinfoEntityToCateringcorpinfo(cateringcorpinfoEntitySaved);
	}

	@Override
	public void delete(Long uid) {
		cateringcorpinfoJpaRepository.delete(uid);
	}

	public CateringcorpinfoJpaRepository getCateringcorpinfoJpaRepository() {
		return cateringcorpinfoJpaRepository;
	}

	public void setCateringcorpinfoJpaRepository(CateringcorpinfoJpaRepository cateringcorpinfoJpaRepository) {
		this.cateringcorpinfoJpaRepository = cateringcorpinfoJpaRepository;
	}

	public CateringcorpinfoServiceMapper getCateringcorpinfoServiceMapper() {
		return cateringcorpinfoServiceMapper;
	}

	public void setCateringcorpinfoServiceMapper(CateringcorpinfoServiceMapper cateringcorpinfoServiceMapper) {
		this.cateringcorpinfoServiceMapper = cateringcorpinfoServiceMapper;
	}

}
