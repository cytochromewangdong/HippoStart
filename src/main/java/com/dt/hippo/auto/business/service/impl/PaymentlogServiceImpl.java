/*
 * Created on 12 五月 2015 ( Time 20:53:05 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.auto.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.dt.hippo.auto.model.Paymentlog;
import com.dt.hippo.auto.model.jpa.PaymentlogEntity;
import java.util.Date;
import com.dt.hippo.auto.business.service.PaymentlogService;
import com.dt.hippo.auto.business.service.mapping.PaymentlogServiceMapper;
import com.dt.hippo.auto.data.repository.jpa.PaymentlogJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of PaymentlogService
 */
@Service("paymentlogService")
@Transactional
public class PaymentlogServiceImpl implements PaymentlogService {

	@Resource
	protected PaymentlogJpaRepository paymentlogJpaRepository;

	@Resource
	protected PaymentlogServiceMapper paymentlogServiceMapper;
	
	@Override
	public Paymentlog findById(Long uid) {
		PaymentlogEntity paymentlogEntity = paymentlogJpaRepository.findOne(uid);
		return paymentlogServiceMapper.mapPaymentlogEntityToPaymentlog(paymentlogEntity);
	}

	@Override
	public List<Paymentlog> findAll() {
		Iterable<PaymentlogEntity> entities = paymentlogJpaRepository.findAll();
		List<Paymentlog> beans = new ArrayList<Paymentlog>();
		for(PaymentlogEntity paymentlogEntity : entities) {
			beans.add(paymentlogServiceMapper.mapPaymentlogEntityToPaymentlog(paymentlogEntity));
		}
		return beans;
	}

	@Override
	public Paymentlog save(Paymentlog paymentlog) {
		return update(paymentlog) ;
	}

	@Override
	public Paymentlog create(Paymentlog paymentlog) {
		PaymentlogEntity paymentlogEntity = paymentlogJpaRepository.findOne(paymentlog.getUid());
		if( paymentlogEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		paymentlogEntity = new PaymentlogEntity();
		paymentlogServiceMapper.mapPaymentlogToPaymentlogEntity(paymentlog, paymentlogEntity);
		PaymentlogEntity paymentlogEntitySaved = paymentlogJpaRepository.save(paymentlogEntity);
		return paymentlogServiceMapper.mapPaymentlogEntityToPaymentlog(paymentlogEntitySaved);
	}

	@Override
	public Paymentlog update(Paymentlog paymentlog) {
		PaymentlogEntity paymentlogEntity = paymentlogJpaRepository.findOne(paymentlog.getUid());
		paymentlogServiceMapper.mapPaymentlogToPaymentlogEntity(paymentlog, paymentlogEntity);
		PaymentlogEntity paymentlogEntitySaved = paymentlogJpaRepository.save(paymentlogEntity);
		return paymentlogServiceMapper.mapPaymentlogEntityToPaymentlog(paymentlogEntitySaved);
	}

	@Override
	public void delete(Long uid) {
		paymentlogJpaRepository.delete(uid);
	}

	public PaymentlogJpaRepository getPaymentlogJpaRepository() {
		return paymentlogJpaRepository;
	}

	public void setPaymentlogJpaRepository(PaymentlogJpaRepository paymentlogJpaRepository) {
		this.paymentlogJpaRepository = paymentlogJpaRepository;
	}

	public PaymentlogServiceMapper getPaymentlogServiceMapper() {
		return paymentlogServiceMapper;
	}

	public void setPaymentlogServiceMapper(PaymentlogServiceMapper paymentlogServiceMapper) {
		this.paymentlogServiceMapper = paymentlogServiceMapper;
	}

}
