package com.dt.hippo.auto.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.dt.hippo.auto.model.jpa.PaymentEntity;

/**
 * Repository : Payment.
 */
public interface PaymentJpaRepository extends PagingAndSortingRepository<PaymentEntity, Long> {

}
