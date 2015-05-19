package com.dt.hippo.auto.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.dt.hippo.auto.model.jpa.CategoryEntity;

/**
 * Repository : Category.
 */
public interface CategoryJpaRepository extends PagingAndSortingRepository<CategoryEntity, Long> {

}
