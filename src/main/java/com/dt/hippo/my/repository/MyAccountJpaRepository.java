package com.dt.hippo.my.repository;

import com.dt.hippo.auto.data.repository.jpa.AccountJpaRepository;
import com.dt.hippo.auto.model.jpa.AccountEntity;

public interface MyAccountJpaRepository extends AccountJpaRepository {
	
//	@Cacheable
	AccountEntity findUserByUsernameAndUsernamehashcode(String username, Integer usernamehashcode);
}
