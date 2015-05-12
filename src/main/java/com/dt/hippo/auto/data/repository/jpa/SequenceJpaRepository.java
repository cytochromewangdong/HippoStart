package com.dt.hippo.auto.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.dt.hippo.auto.model.jpa.SequenceEntity;
import com.dt.hippo.auto.model.jpa.SequenceEntityKey;

/**
 * Repository : Sequence.
 */
public interface SequenceJpaRepository extends PagingAndSortingRepository<SequenceEntity, SequenceEntityKey> {

}
