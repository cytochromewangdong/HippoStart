package com.dt.hippo.auto.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.dt.hippo.auto.model.jpa.AdlistEntity;

/**
 * Repository : Adlist.
 */
public interface AdlistJpaRepository extends PagingAndSortingRepository<AdlistEntity, Long> {

}
