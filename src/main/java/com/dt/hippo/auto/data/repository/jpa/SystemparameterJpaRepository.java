package com.dt.hippo.auto.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.dt.hippo.auto.model.jpa.SystemparameterEntity;

/**
 * Repository : Systemparameter.
 */
public interface SystemparameterJpaRepository extends PagingAndSortingRepository<SystemparameterEntity, Integer> {

}
