package com.dt.hippo.auto.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.dt.hippo.auto.model.jpa.AccountEntity;

/**
 * Repository : Account.
 */
public interface AccountJpaRepository extends PagingAndSortingRepository<AccountEntity, Long> {

}
