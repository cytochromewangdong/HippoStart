/*
 * Created on 10 五月 2015 ( Time 21:36:20 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.datajpa.business.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.dt.hippo.datajpa.model.jpa.Account;
import java.util.Date;
import com.dt.hippo.datajpa.business.service.AccountService;
import com.dt.hippo.datajpa.data.repository.jpa.AccountJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of AccountService
 */
@Component
@Transactional
public class AccountServiceImpl implements AccountService {

	@Resource
	private AccountJpaRepository accountJpaRepository;

	
	@Override
    @Transactional(readOnly = true)
	public Account findById(Long id) {
		return accountJpaRepository.findOne(id);
	}

	@Override
    @Transactional(readOnly = true)
	public List<Account> findAll() {
		return  accountJpaRepository.findAll();
	}

	@Override
	public Account save(Account account) {
		return accountJpaRepository.save(account) ;
	}

	@Override
	public Account create(Account account) {
		Account accountExisted = accountJpaRepository.findOne(account.getId());
		if( accountExisted != null ) {
			throw new IllegalStateException("already.exists");
		}
		return accountJpaRepository.save(account);
	}

	@Override
	public Account update(Account account) {
		Account accountExisted = accountJpaRepository.findOne(account.getId());
        if (accountExisted == null) {
            throw new IllegalStateException("not exists");
        }
		return accountJpaRepository.save(account);
	}

	@Override
	public void delete(Long id) {
		accountJpaRepository.delete(id);
	}

	public AccountJpaRepository getAccountJpaRepository() {
		return accountJpaRepository;
	}

	public void setAccountJpaRepository(AccountJpaRepository accountJpaRepository) {
		this.accountJpaRepository = accountJpaRepository;
	}



}