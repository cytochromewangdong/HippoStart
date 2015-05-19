/*
 * Created on 18 五月 2015 ( Time 11:07:12 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.auto.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.dt.hippo.auto.model.Mediaresource;
import com.dt.hippo.auto.model.jpa.MediaresourceEntity;
import java.util.Date;
import com.dt.hippo.auto.business.service.MediaresourceService;
import com.dt.hippo.auto.business.service.mapping.MediaresourceServiceMapper;
import com.dt.hippo.auto.data.repository.jpa.MediaresourceJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of MediaresourceService
 */
@Service("mediaresourceService")
@Transactional
public class MediaresourceServiceImpl implements MediaresourceService {

	@Resource
	protected MediaresourceJpaRepository mediaresourceJpaRepository;

	@Resource
	protected MediaresourceServiceMapper mediaresourceServiceMapper;
	
	@Override
	public Mediaresource findById(Long uid) {
		MediaresourceEntity mediaresourceEntity = mediaresourceJpaRepository.findOne(uid);
		return mediaresourceServiceMapper.mapMediaresourceEntityToMediaresource(mediaresourceEntity);
	}

	@Override
	public List<Mediaresource> findAll() {
		Iterable<MediaresourceEntity> entities = mediaresourceJpaRepository.findAll();
		List<Mediaresource> beans = new ArrayList<Mediaresource>();
		for(MediaresourceEntity mediaresourceEntity : entities) {
			beans.add(mediaresourceServiceMapper.mapMediaresourceEntityToMediaresource(mediaresourceEntity));
		}
		return beans;
	}

	@Override
	public Mediaresource save(Mediaresource mediaresource) {
		return update(mediaresource) ;
	}

	@Override
	public Mediaresource create(Mediaresource mediaresource) {
//		MediaresourceEntity mediaresourceEntity = mediaresourceJpaRepository.findOne(mediaresource.getUid());
//		if( mediaresourceEntity != null ) {
//			throw new IllegalStateException("already.exists");
//		}
		MediaresourceEntity mediaresourceEntity = new MediaresourceEntity();
		mediaresourceServiceMapper.mapMediaresourceToMediaresourceEntity(mediaresource, mediaresourceEntity);
		MediaresourceEntity mediaresourceEntitySaved = mediaresourceJpaRepository.save(mediaresourceEntity);
		return mediaresourceServiceMapper.mapMediaresourceEntityToMediaresource(mediaresourceEntitySaved);
	}

	@Override
	public Mediaresource update(Mediaresource mediaresource) {
		MediaresourceEntity mediaresourceEntity = mediaresourceJpaRepository.findOne(mediaresource.getUid());
		mediaresourceServiceMapper.mapMediaresourceToMediaresourceEntity(mediaresource, mediaresourceEntity);
		MediaresourceEntity mediaresourceEntitySaved = mediaresourceJpaRepository.save(mediaresourceEntity);
		return mediaresourceServiceMapper.mapMediaresourceEntityToMediaresource(mediaresourceEntitySaved);
	}

	@Override
	public void delete(Long uid) {
		mediaresourceJpaRepository.delete(uid);
	}

	public MediaresourceJpaRepository getMediaresourceJpaRepository() {
		return mediaresourceJpaRepository;
	}

	public void setMediaresourceJpaRepository(MediaresourceJpaRepository mediaresourceJpaRepository) {
		this.mediaresourceJpaRepository = mediaresourceJpaRepository;
	}

	public MediaresourceServiceMapper getMediaresourceServiceMapper() {
		return mediaresourceServiceMapper;
	}

	public void setMediaresourceServiceMapper(MediaresourceServiceMapper mediaresourceServiceMapper) {
		this.mediaresourceServiceMapper = mediaresourceServiceMapper;
	}

}
