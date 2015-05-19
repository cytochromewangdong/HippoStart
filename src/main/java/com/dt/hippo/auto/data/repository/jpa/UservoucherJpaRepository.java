package com.dt.hippo.auto.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.dt.hippo.auto.model.jpa.UservoucherEntity;

/**
 * Repository : Uservoucher.
 */
public interface UservoucherJpaRepository extends PagingAndSortingRepository<UservoucherEntity, Long> {

}
