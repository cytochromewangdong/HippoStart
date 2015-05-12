package com.dt.hippo.auto.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.dt.hippo.auto.model.jpa.ExternalaccountEntity;
import com.dt.hippo.auto.model.jpa.ExternalaccountEntityKey;

/**
 * Repository : Externalaccount.
 */
public interface ExternalaccountJpaRepository extends PagingAndSortingRepository<ExternalaccountEntity, ExternalaccountEntityKey> {

}
