package com.dt.hippo.my.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dt.hippo.auto.data.repository.jpa.AccountJpaRepository;
import com.dt.hippo.auto.model.jpa.AccountEntity;
import com.dt.hippo.business.base.SuperService;
import com.dt.hippo.business.model.com.UserCom;
import com.dt.hippo.my.service.CstUserService;

@Service
@Transactional
public class CstUserServiceImpl extends SuperService implements
		CstUserService
{

	@Resource
	protected AccountJpaRepository accountJpaRepository;

	@Override
	public UserCom register(UserCom com)
	{
		if (getUserByUserNameOrEmail(com.getUserName()) != null)
		{
			RaiseExceptionWithkey("global.existed",
					com.getUserName());
			// return
		}
		if (getUserByUserNameOrEmail(com.getEmail()) != null)
		{
			RaiseExceptionWithkey("global.existed",
					com.getEmail());
			// return
		}
		return com;
	}

	public AccountEntity getUserByUserNameOrEmail(
			String usernameOrEmail)
	{
		if (usernameOrEmail == null)
		{
			return null;
		}
		String lowerCaseUsernameOrEmail = usernameOrEmail
				.toLowerCase().trim();
		AccountEntity account = accountJpaRepository
				.findUserInformationWithusernameOrEmail(
						usernameOrEmail,
						lowerCaseUsernameOrEmail.hashCode());
		return account;
	}

}
