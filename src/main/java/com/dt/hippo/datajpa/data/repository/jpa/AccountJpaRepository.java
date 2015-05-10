package com.dt.hippo.datajpa.data.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dt.hippo.datajpa.model.jpa.Account;

/**
 * Repository : Account.
 */
public interface AccountJpaRepository extends JpaRepository<Account, Long> {

}
