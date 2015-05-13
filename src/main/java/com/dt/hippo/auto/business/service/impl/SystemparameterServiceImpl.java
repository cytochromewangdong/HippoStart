/*
 * Created on 13 五月 2015 ( Time 21:15:32 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.auto.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.dt.hippo.auto.model.Systemparameter;
import com.dt.hippo.auto.model.jpa.SystemparameterEntity;
import com.dt.hippo.auto.business.service.SystemparameterService;
import com.dt.hippo.auto.business.service.mapping.SystemparameterServiceMapper;
import com.dt.hippo.auto.data.repository.jpa.SystemparameterJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of SystemparameterService
 */
@Service("systemparameterService")
@Transactional
public class SystemparameterServiceImpl implements SystemparameterService {

	@Resource
	protected SystemparameterJpaRepository systemparameterJpaRepository;

	@Resource
	protected SystemparameterServiceMapper systemparameterServiceMapper;
	
	@Override
	public Systemparameter findById(Integer uid) {
		SystemparameterEntity systemparameterEntity = systemparameterJpaRepository.findOne(uid);
		return systemparameterServiceMapper.mapSystemparameterEntityToSystemparameter(systemparameterEntity);
	}

	@Override
	public List<Systemparameter> findAll() {
		Iterable<SystemparameterEntity> entities = systemparameterJpaRepository.findAll();
		List<Systemparameter> beans = new ArrayList<Systemparameter>();
		for(SystemparameterEntity systemparameterEntity : entities) {
			beans.add(systemparameterServiceMapper.mapSystemparameterEntityToSystemparameter(systemparameterEntity));
		}
		return beans;
	}

	@Override
	public Systemparameter save(Systemparameter systemparameter) {
		return update(systemparameter) ;
	}

	@Override
	public Systemparameter create(Systemparameter systemparameter) {
		SystemparameterEntity systemparameterEntity = systemparameterJpaRepository.findOne(systemparameter.getUid());
		if( systemparameterEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		systemparameterEntity = new SystemparameterEntity();
		systemparameterServiceMapper.mapSystemparameterToSystemparameterEntity(systemparameter, systemparameterEntity);
		SystemparameterEntity systemparameterEntitySaved = systemparameterJpaRepository.save(systemparameterEntity);
		return systemparameterServiceMapper.mapSystemparameterEntityToSystemparameter(systemparameterEntitySaved);
	}

	@Override
	public Systemparameter update(Systemparameter systemparameter) {
		SystemparameterEntity systemparameterEntity = systemparameterJpaRepository.findOne(systemparameter.getUid());
		systemparameterServiceMapper.mapSystemparameterToSystemparameterEntity(systemparameter, systemparameterEntity);
		SystemparameterEntity systemparameterEntitySaved = systemparameterJpaRepository.save(systemparameterEntity);
		return systemparameterServiceMapper.mapSystemparameterEntityToSystemparameter(systemparameterEntitySaved);
	}

	@Override
	public void delete(Integer uid) {
		systemparameterJpaRepository.delete(uid);
	}

	public SystemparameterJpaRepository getSystemparameterJpaRepository() {
		return systemparameterJpaRepository;
	}

	public void setSystemparameterJpaRepository(SystemparameterJpaRepository systemparameterJpaRepository) {
		this.systemparameterJpaRepository = systemparameterJpaRepository;
	}

	public SystemparameterServiceMapper getSystemparameterServiceMapper() {
		return systemparameterServiceMapper;
	}

	public void setSystemparameterServiceMapper(SystemparameterServiceMapper systemparameterServiceMapper) {
		this.systemparameterServiceMapper = systemparameterServiceMapper;
	}

}
