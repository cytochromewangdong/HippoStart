/*
 * Created on 12 五月 2015 ( Time 20:53:03 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.auto.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.dt.hippo.auto.model.Orderdetail;
import com.dt.hippo.auto.model.jpa.OrderdetailEntity;
import com.dt.hippo.auto.model.jpa.OrderdetailEntityKey;
import java.util.Date;
import com.dt.hippo.auto.business.service.OrderdetailService;
import com.dt.hippo.auto.business.service.mapping.OrderdetailServiceMapper;
import com.dt.hippo.auto.data.repository.jpa.OrderdetailJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of OrderdetailService
 */
@Service("orderdetailService")
@Transactional
public class OrderdetailServiceImpl implements OrderdetailService {

	@Resource
	protected OrderdetailJpaRepository orderdetailJpaRepository;

	@Resource
	protected OrderdetailServiceMapper orderdetailServiceMapper;
	
	@Override
	public Orderdetail findById(String orderno, Long uid) {
		OrderdetailEntityKey id = new OrderdetailEntityKey(orderno, uid);
		OrderdetailEntity orderdetailEntity = orderdetailJpaRepository.findOne(id);
		return orderdetailServiceMapper.mapOrderdetailEntityToOrderdetail(orderdetailEntity);
	}

	@Override
	public List<Orderdetail> findAll() {
		Iterable<OrderdetailEntity> entities = orderdetailJpaRepository.findAll();
		List<Orderdetail> beans = new ArrayList<Orderdetail>();
		for(OrderdetailEntity orderdetailEntity : entities) {
			beans.add(orderdetailServiceMapper.mapOrderdetailEntityToOrderdetail(orderdetailEntity));
		}
		return beans;
	}

	@Override
	public Orderdetail save(Orderdetail orderdetail) {
		return update(orderdetail) ;
	}

	@Override
	public Orderdetail create(Orderdetail orderdetail) {
		OrderdetailEntityKey id = new OrderdetailEntityKey(orderdetail.getOrderno(), orderdetail.getUid());
		OrderdetailEntity orderdetailEntity = orderdetailJpaRepository.findOne(id);
		if( orderdetailEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		orderdetailEntity = new OrderdetailEntity();
		orderdetailServiceMapper.mapOrderdetailToOrderdetailEntity(orderdetail, orderdetailEntity);
		OrderdetailEntity orderdetailEntitySaved = orderdetailJpaRepository.save(orderdetailEntity);
		return orderdetailServiceMapper.mapOrderdetailEntityToOrderdetail(orderdetailEntitySaved);
	}

	@Override
	public Orderdetail update(Orderdetail orderdetail) {
		OrderdetailEntityKey id = new OrderdetailEntityKey(orderdetail.getOrderno(), orderdetail.getUid());
		OrderdetailEntity orderdetailEntity = orderdetailJpaRepository.findOne(id);
		orderdetailServiceMapper.mapOrderdetailToOrderdetailEntity(orderdetail, orderdetailEntity);
		OrderdetailEntity orderdetailEntitySaved = orderdetailJpaRepository.save(orderdetailEntity);
		return orderdetailServiceMapper.mapOrderdetailEntityToOrderdetail(orderdetailEntitySaved);
	}

	@Override
	public void delete(String orderno, Long uid) {
		OrderdetailEntityKey id = new OrderdetailEntityKey(orderno, uid);
		orderdetailJpaRepository.delete(id);
	}

	public OrderdetailJpaRepository getOrderdetailJpaRepository() {
		return orderdetailJpaRepository;
	}

	public void setOrderdetailJpaRepository(OrderdetailJpaRepository orderdetailJpaRepository) {
		this.orderdetailJpaRepository = orderdetailJpaRepository;
	}

	public OrderdetailServiceMapper getOrderdetailServiceMapper() {
		return orderdetailServiceMapper;
	}

	public void setOrderdetailServiceMapper(OrderdetailServiceMapper orderdetailServiceMapper) {
		this.orderdetailServiceMapper = orderdetailServiceMapper;
	}

}
