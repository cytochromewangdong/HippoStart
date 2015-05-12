package com.dt.hippo.auto.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.dt.hippo.auto.model.jpa.PointruleEntity;

/**
 * Repository : Pointrule.
 */
public interface PointruleJpaRepository extends PagingAndSortingRepository<PointruleEntity, Byte> {

}
