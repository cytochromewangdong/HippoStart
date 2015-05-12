package com.dt.hippo.auto.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.dt.hippo.auto.model.jpa.AdministratorEntity;

/**
 * Repository : Administrator.
 */
public interface AdministratorJpaRepository extends PagingAndSortingRepository<AdministratorEntity, Long> {

}
