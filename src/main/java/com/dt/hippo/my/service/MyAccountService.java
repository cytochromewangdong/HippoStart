package com.dt.hippo.my.service;

import com.dt.hippo.auto.business.service.AccountService;
import com.dt.hippo.auto.model.Account;

public interface MyAccountService extends AccountService {
	public Account getUser(String username);
}
