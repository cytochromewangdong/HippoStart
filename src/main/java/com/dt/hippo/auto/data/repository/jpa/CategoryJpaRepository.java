package com.dt.hippo.auto.data.repository.jpa;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.dt.hippo.auto.model.jpa.CategoryEntity;
import com.dt.hippo.auto.model.jpa.CategoryEntityKey;

/**
 * Repository : Category.
 */
public interface CategoryJpaRepository extends PagingAndSortingRepository<CategoryEntity, CategoryEntityKey> {

	CategoryEntity findWhatIWant(int status);
	List<CategoryEntity> findByName(String name);
}
