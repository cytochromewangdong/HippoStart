package com.dt.hippo.my.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dt.hippo.auto.business.service.impl.AccountServiceImpl;
import com.dt.hippo.auto.data.repository.jpa.AccountJpaRepository;
import com.dt.hippo.auto.model.Account;
import com.dt.hippo.my.service.MyAccountService;

@Service
@Transactional
public class MyAccountServiceImpl extends AccountServiceImpl implements MyAccountService {

	@Resource
	protected AccountJpaRepository accountJpaRepository;

	@Transactional(readOnly=true)
	public Account getUser(String username) {
		if (username == null) {
			return null;
		}
		username = username.toLowerCase();
		return accountServiceMapper
				.mapAccountEntityToAccount(accountJpaRepository
						.findUserInformationWithusernameOrEmail(username,
								username.hashCode()));
	}
}
