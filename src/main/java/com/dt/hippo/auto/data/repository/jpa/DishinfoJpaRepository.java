package com.dt.hippo.auto.data.repository.jpa;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.dt.hippo.auto.model.jpa.DishinfoEntity;

/**
 * Repository : Dishinfo.
 */
public interface DishinfoJpaRepository extends PagingAndSortingRepository<DishinfoEntity, Long> {
	@Lock(LockModeType.WRITE)
	DishinfoEntity findOne(Long id);
}
