package com.dt.hippo.auto.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.dt.hippo.auto.model.jpa.PromotiondetailinfoEntity;
import com.dt.hippo.auto.model.jpa.PromotiondetailinfoEntityKey;

/**
 * Repository : Promotiondetailinfo.
 */
public interface PromotiondetailinfoJpaRepository extends PagingAndSortingRepository<PromotiondetailinfoEntity, PromotiondetailinfoEntityKey> {

}
