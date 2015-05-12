package com.dt.hippo.auto.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.dt.hippo.auto.model.jpa.DishspecificationinfoEntity;
import com.dt.hippo.auto.model.jpa.DishspecificationinfoEntityKey;

/**
 * Repository : Dishspecificationinfo.
 */
public interface DishspecificationinfoJpaRepository extends PagingAndSortingRepository<DishspecificationinfoEntity, DishspecificationinfoEntityKey> {

}
