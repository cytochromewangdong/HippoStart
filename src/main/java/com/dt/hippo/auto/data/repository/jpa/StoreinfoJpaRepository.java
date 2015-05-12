package com.dt.hippo.auto.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.dt.hippo.auto.model.jpa.StoreinfoEntity;

/**
 * Repository : Storeinfo.
 */
public interface StoreinfoJpaRepository extends PagingAndSortingRepository<StoreinfoEntity, Long> {

}
