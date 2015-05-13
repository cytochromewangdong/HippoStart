/*
 * Created on 13 五月 2015 ( Time 21:15:30 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.auto.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.dt.hippo.auto.model.Promotioninfo;
import com.dt.hippo.auto.model.jpa.PromotioninfoEntity;
import java.util.Date;
import com.dt.hippo.auto.business.service.PromotioninfoService;
import com.dt.hippo.auto.business.service.mapping.PromotioninfoServiceMapper;
import com.dt.hippo.auto.data.repository.jpa.PromotioninfoJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of PromotioninfoService
 */
@Service("promotioninfoService")
@Transactional
public class PromotioninfoServiceImpl implements PromotioninfoService {

	@Resource
	protected PromotioninfoJpaRepository promotioninfoJpaRepository;

	@Resource
	protected PromotioninfoServiceMapper promotioninfoServiceMapper;
	
	@Override
	public Promotioninfo findById(Long uid) {
		PromotioninfoEntity promotioninfoEntity = promotioninfoJpaRepository.findOne(uid);
		return promotioninfoServiceMapper.mapPromotioninfoEntityToPromotioninfo(promotioninfoEntity);
	}

	@Override
	public List<Promotioninfo> findAll() {
		Iterable<PromotioninfoEntity> entities = promotioninfoJpaRepository.findAll();
		List<Promotioninfo> beans = new ArrayList<Promotioninfo>();
		for(PromotioninfoEntity promotioninfoEntity : entities) {
			beans.add(promotioninfoServiceMapper.mapPromotioninfoEntityToPromotioninfo(promotioninfoEntity));
		}
		return beans;
	}

	@Override
	public Promotioninfo save(Promotioninfo promotioninfo) {
		return update(promotioninfo) ;
	}

	@Override
	public Promotioninfo create(Promotioninfo promotioninfo) {
		PromotioninfoEntity promotioninfoEntity = promotioninfoJpaRepository.findOne(promotioninfo.getUid());
		if( promotioninfoEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		promotioninfoEntity = new PromotioninfoEntity();
		promotioninfoServiceMapper.mapPromotioninfoToPromotioninfoEntity(promotioninfo, promotioninfoEntity);
		PromotioninfoEntity promotioninfoEntitySaved = promotioninfoJpaRepository.save(promotioninfoEntity);
		return promotioninfoServiceMapper.mapPromotioninfoEntityToPromotioninfo(promotioninfoEntitySaved);
	}

	@Override
	public Promotioninfo update(Promotioninfo promotioninfo) {
		PromotioninfoEntity promotioninfoEntity = promotioninfoJpaRepository.findOne(promotioninfo.getUid());
		promotioninfoServiceMapper.mapPromotioninfoToPromotioninfoEntity(promotioninfo, promotioninfoEntity);
		PromotioninfoEntity promotioninfoEntitySaved = promotioninfoJpaRepository.save(promotioninfoEntity);
		return promotioninfoServiceMapper.mapPromotioninfoEntityToPromotioninfo(promotioninfoEntitySaved);
	}

	@Override
	public void delete(Long uid) {
		promotioninfoJpaRepository.delete(uid);
	}

	public PromotioninfoJpaRepository getPromotioninfoJpaRepository() {
		return promotioninfoJpaRepository;
	}

	public void setPromotioninfoJpaRepository(PromotioninfoJpaRepository promotioninfoJpaRepository) {
		this.promotioninfoJpaRepository = promotioninfoJpaRepository;
	}

	public PromotioninfoServiceMapper getPromotioninfoServiceMapper() {
		return promotioninfoServiceMapper;
	}

	public void setPromotioninfoServiceMapper(PromotioninfoServiceMapper promotioninfoServiceMapper) {
		this.promotioninfoServiceMapper = promotioninfoServiceMapper;
	}

}
