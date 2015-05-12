package com.dt.hippo.auto.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.dt.hippo.auto.model.jpa.DishinfoEntity;

/**
 * Repository : Dishinfo.
 */
public interface DishinfoJpaRepository extends PagingAndSortingRepository<DishinfoEntity, Long> {

}
