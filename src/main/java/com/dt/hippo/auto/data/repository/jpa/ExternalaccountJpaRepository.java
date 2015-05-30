package com.dt.hippo.auto.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.dt.hippo.auto.model.jpa.ExternalaccountEntity;

/**
 * Repository : Externalaccount.
 */
public interface ExternalaccountJpaRepository
		extends
		PagingAndSortingRepository<ExternalaccountEntity, Long>
{
	ExternalaccountEntity findByUseridAndUsersource(
			Long userid, int usersource);
}
