/*
 * Created on 13 五月 2015 ( Time 21:15:23 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.auto.business.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import com.dt.hippo.auto.model.Category;
import com.dt.hippo.auto.model.jpa.CategoryEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class CategoryServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public CategoryServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'CategoryEntity' to 'Category'
	 * @param categoryEntity
	 */
	public Category mapCategoryEntityToCategory(CategoryEntity categoryEntity) {
		if(categoryEntity == null) {
			return null;
		}

		//--- Generic mapping 
		Category category = map(categoryEntity, Category.class);
		return category;
	}
	
	/**
	 * Mapping from 'Category' to 'CategoryEntity'
	 * @param category
	 * @param categoryEntity
	 */
	public void mapCategoryToCategoryEntity(Category category, CategoryEntity categoryEntity) {
		if(category == null) {
			return;
		}

		//--- Generic mapping 
		map(category, categoryEntity);

	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ModelMapper getModelMapper() {
		return modelMapper;
	}

	protected void setModelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

}