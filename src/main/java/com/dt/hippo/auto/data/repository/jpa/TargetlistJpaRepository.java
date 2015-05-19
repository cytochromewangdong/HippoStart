package com.dt.hippo.auto.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.dt.hippo.auto.model.jpa.TargetlistEntity;
import com.dt.hippo.auto.model.jpa.TargetlistEntityKey;

/**
 * Repository : Targetlist.
 */
public interface TargetlistJpaRepository extends PagingAndSortingRepository<TargetlistEntity, TargetlistEntityKey> {

}
