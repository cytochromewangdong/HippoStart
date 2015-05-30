package com.dt.hippo.auto.data.repository.jpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.dt.hippo.auto.model.jpa.AccountEntity;

/**
 * Repository : Account.
 */
public interface AccountJpaRepository extends PagingAndSortingRepository<AccountEntity, Long> {

	@Query("SELECT a FROM AccountEntity a WHERE (a.username =?1 and a.usernamehashcode=?2) or (a.email=?1 and a.emailhashcode=?2)")
	AccountEntity findUserInformationWithusernameOrEmail(String usernameOrEmail, int hashcode);
}
