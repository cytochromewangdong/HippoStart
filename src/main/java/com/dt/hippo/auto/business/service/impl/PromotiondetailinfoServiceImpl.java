/*
 * Created on 12 五月 2015 ( Time 20:53:06 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.auto.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.dt.hippo.auto.model.Promotiondetailinfo;
import com.dt.hippo.auto.model.jpa.PromotiondetailinfoEntity;
import com.dt.hippo.auto.model.jpa.PromotiondetailinfoEntityKey;
import java.util.Date;
import com.dt.hippo.auto.business.service.PromotiondetailinfoService;
import com.dt.hippo.auto.business.service.mapping.PromotiondetailinfoServiceMapper;
import com.dt.hippo.auto.data.repository.jpa.PromotiondetailinfoJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of PromotiondetailinfoService
 */
@Service("promotiondetailinfoService")
@Transactional
public class PromotiondetailinfoServiceImpl implements PromotiondetailinfoService {

	@Resource
	protected PromotiondetailinfoJpaRepository promotiondetailinfoJpaRepository;

	@Resource
	protected PromotiondetailinfoServiceMapper promotiondetailinfoServiceMapper;
	
	@Override
	public Promotiondetailinfo findById(Long uid, Long dishid, Long specificationid) {
		PromotiondetailinfoEntityKey id = new PromotiondetailinfoEntityKey(uid, dishid, specificationid);
		PromotiondetailinfoEntity promotiondetailinfoEntity = promotiondetailinfoJpaRepository.findOne(id);
		return promotiondetailinfoServiceMapper.mapPromotiondetailinfoEntityToPromotiondetailinfo(promotiondetailinfoEntity);
	}

	@Override
	public List<Promotiondetailinfo> findAll() {
		Iterable<PromotiondetailinfoEntity> entities = promotiondetailinfoJpaRepository.findAll();
		List<Promotiondetailinfo> beans = new ArrayList<Promotiondetailinfo>();
		for(PromotiondetailinfoEntity promotiondetailinfoEntity : entities) {
			beans.add(promotiondetailinfoServiceMapper.mapPromotiondetailinfoEntityToPromotiondetailinfo(promotiondetailinfoEntity));
		}
		return beans;
	}

	@Override
	public Promotiondetailinfo save(Promotiondetailinfo promotiondetailinfo) {
		return update(promotiondetailinfo) ;
	}

	@Override
	public Promotiondetailinfo create(Promotiondetailinfo promotiondetailinfo) {
		PromotiondetailinfoEntityKey id = new PromotiondetailinfoEntityKey(promotiondetailinfo.getUid(), promotiondetailinfo.getDishid(), promotiondetailinfo.getSpecificationid());
		PromotiondetailinfoEntity promotiondetailinfoEntity = promotiondetailinfoJpaRepository.findOne(id);
		if( promotiondetailinfoEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		promotiondetailinfoEntity = new PromotiondetailinfoEntity();
		promotiondetailinfoServiceMapper.mapPromotiondetailinfoToPromotiondetailinfoEntity(promotiondetailinfo, promotiondetailinfoEntity);
		PromotiondetailinfoEntity promotiondetailinfoEntitySaved = promotiondetailinfoJpaRepository.save(promotiondetailinfoEntity);
		return promotiondetailinfoServiceMapper.mapPromotiondetailinfoEntityToPromotiondetailinfo(promotiondetailinfoEntitySaved);
	}

	@Override
	public Promotiondetailinfo update(Promotiondetailinfo promotiondetailinfo) {
		PromotiondetailinfoEntityKey id = new PromotiondetailinfoEntityKey(promotiondetailinfo.getUid(), promotiondetailinfo.getDishid(), promotiondetailinfo.getSpecificationid());
		PromotiondetailinfoEntity promotiondetailinfoEntity = promotiondetailinfoJpaRepository.findOne(id);
		promotiondetailinfoServiceMapper.mapPromotiondetailinfoToPromotiondetailinfoEntity(promotiondetailinfo, promotiondetailinfoEntity);
		PromotiondetailinfoEntity promotiondetailinfoEntitySaved = promotiondetailinfoJpaRepository.save(promotiondetailinfoEntity);
		return promotiondetailinfoServiceMapper.mapPromotiondetailinfoEntityToPromotiondetailinfo(promotiondetailinfoEntitySaved);
	}

	@Override
	public void delete(Long uid, Long dishid, Long specificationid) {
		PromotiondetailinfoEntityKey id = new PromotiondetailinfoEntityKey(uid, dishid, specificationid);
		promotiondetailinfoJpaRepository.delete(id);
	}

	public PromotiondetailinfoJpaRepository getPromotiondetailinfoJpaRepository() {
		return promotiondetailinfoJpaRepository;
	}

	public void setPromotiondetailinfoJpaRepository(PromotiondetailinfoJpaRepository promotiondetailinfoJpaRepository) {
		this.promotiondetailinfoJpaRepository = promotiondetailinfoJpaRepository;
	}

	public PromotiondetailinfoServiceMapper getPromotiondetailinfoServiceMapper() {
		return promotiondetailinfoServiceMapper;
	}

	public void setPromotiondetailinfoServiceMapper(PromotiondetailinfoServiceMapper promotiondetailinfoServiceMapper) {
		this.promotiondetailinfoServiceMapper = promotiondetailinfoServiceMapper;
	}

}
