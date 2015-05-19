package com.dt.hippo.auto.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.dt.hippo.auto.model.jpa.DishpriceEntity;

/**
 * Repository : Dishprice.
 */
public interface DishpriceJpaRepository extends PagingAndSortingRepository<DishpriceEntity, Long> {

}
