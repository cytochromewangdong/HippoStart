package com.dt.hippo.auto.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.dt.hippo.auto.model.jpa.OrderdetailEntity;

/**
 * Repository : Orderdetail.
 */
public interface OrderdetailJpaRepository extends PagingAndSortingRepository<OrderdetailEntity, Long> {

}
