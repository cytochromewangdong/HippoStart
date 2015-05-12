package com.dt.hippo.datajpa.data.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dt.hippo.datajpa.model.jpa.Category;
import com.dt.hippo.datajpa.model.jpa.CategoryKey;

/**
 * Repository : Category.
 */
public interface CategoryJpaRepository extends JpaRepository<Category, CategoryKey> {

}
