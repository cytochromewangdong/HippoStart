package com.dt.hippo.auto.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.dt.hippo.auto.model.jpa.OrderheaderEntity;

/**
 * Repository : Orderheader.
 */
public interface OrderheaderJpaRepository extends PagingAndSortingRepository<OrderheaderEntity, Long> {

}
