package com.dt.hippo.auto.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.dt.hippo.auto.model.jpa.PaymentlogEntity;

/**
 * Repository : Paymentlog.
 */
public interface PaymentlogJpaRepository extends PagingAndSortingRepository<PaymentlogEntity, Long> {

}
