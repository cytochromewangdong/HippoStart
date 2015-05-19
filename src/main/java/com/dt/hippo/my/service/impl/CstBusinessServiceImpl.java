package com.dt.hippo.my.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dt.hippo.auto.business.service.mapping.CategoryServiceMapper;
import com.dt.hippo.auto.model.Category;
import com.dt.hippo.auto.model.jpa.CategoryEntity;
import com.dt.hippo.auto.model.jpa.DishinfoEntity;
import com.dt.hippo.business.base.SuperService;
import com.dt.hippo.my.repository.CstCategoryJpaRepository;
import com.dt.hippo.my.service.CstBusinessService;

@Service
@Transactional
public class CstBusinessServiceImpl extends SuperService
		implements CstBusinessService
{
	@Resource
	private CstCategoryJpaRepository cstCategoryJpaRepository;

	@Resource
	protected CategoryServiceMapper categoryServiceMapper;

	@Transactional(readOnly = true)
	public List<Category> getAllValidCategoryAndDishInfoOfCorp(
			long corpid)
	{
		List<CategoryEntity> categoryList = cstCategoryJpaRepository
				.findByCorpidAndStatus(corpid, 0);
		List<Category> beans = new ArrayList<Category>();
		for (CategoryEntity category : categoryList)
		{
			category.setListOfDishinfo(this
					.filterStatus(category.getListOfDishinfo()));
			for (DishinfoEntity dish : category
					.getListOfDishinfo())
			{
				dish.setListOfDishspecificationinfo(this.filterStatus(dish
						.getListOfDishspecificationinfo()));

			}
			beans.add(categoryServiceMapper
					.mapCategoryEntityToCategory(category));
		}

		return beans;

	}
}
