package com.dt.hippo.auto.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.dt.hippo.auto.model.jpa.ComboinfoEntity;
import com.dt.hippo.auto.model.jpa.ComboinfoEntityKey;

/**
 * Repository : Comboinfo.
 */
public interface ComboinfoJpaRepository extends PagingAndSortingRepository<ComboinfoEntity, ComboinfoEntityKey> {

}
