package com.dt.hippo.my.service;

import com.dt.hippo.auto.model.jpa.AccountEntity;
import com.dt.hippo.business.model.com.UserCom;

public interface CstUserService
{
	public UserCom register(UserCom com) ;
	public AccountEntity getUserByUserNameOrEmail(String usernameOrEmail);
}
