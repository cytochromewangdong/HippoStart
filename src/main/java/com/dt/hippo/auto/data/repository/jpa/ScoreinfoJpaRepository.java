package com.dt.hippo.auto.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.dt.hippo.auto.model.jpa.ScoreinfoEntity;

/**
 * Repository : Scoreinfo.
 */
public interface ScoreinfoJpaRepository extends PagingAndSortingRepository<ScoreinfoEntity, Long> {

}
