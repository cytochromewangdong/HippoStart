package com.dt.hippo.my.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dt.hippo.auto.business.service.mapping.CategoryServiceMapper;
import com.dt.hippo.auto.data.repository.jpa.StoreinfoJpaRepository;
import com.dt.hippo.auto.model.Category;
import com.dt.hippo.auto.model.jpa.CategoryEntity;
import com.dt.hippo.auto.model.jpa.DishinfoEntity;
import com.dt.hippo.auto.model.jpa.DishspecificationinfoEntity;
import com.dt.hippo.auto.model.jpa.StoreinfoEntity;
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
	
	@Resource 
	protected StoreinfoJpaRepository storeinfoJpaRepository;

	@Transactional(readOnly = true)
	public List<Category> getAllValidCategoryAndDishInfoOfCorp(long storeId)
	{
		StoreinfoEntity storeinfoEntity = storeinfoJpaRepository.findOne(storeId);
		List<CategoryEntity> categoryList = cstCategoryJpaRepository
				.findByCorpidAndStatus(storeinfoEntity.getCorpid(), 0);
		List<Category> beans = new ArrayList<Category>();
		for (CategoryEntity category : categoryList)
		{
//			category.setListOfDishinfo(this
//					.filterStatus(category.getListOfDishinfo()));
			// remove the dishes which are waiting to be approved or temporarily paused
			// or it is not for sale
//			category.setListOfDishinfo(Lists
//					.newArrayList(Collections2.filter(
//							category.getListOfDishinfo(),
//							new Predicate<DishinfoEntity>()
//							{
//
//								@Override
//								public boolean apply(
//										DishinfoEntity input)
//								{
//									return (input.getStatus() == null || input
//											.getStatus().equals(
//													0))
//											&& input.getPaused() == 0 && input.getNotforsale() == 0;
//								}
//							})));
			List<DishinfoEntity> newDishList = new ArrayList<DishinfoEntity>();
			for (DishinfoEntity dish : category
					.getListOfDishinfo())
			{
				if ((dish.getStatus() == null || dish
						.getStatus() == 0)
						&& dish.getPaused() == 0
						&& dish.getNotforsale() == 0)
				{
					// for each dish, we remove the specifications which are not
					// approved
//					dish.setListOfDishspecificationinfo(this.filterStatus(dish
//							.getListOfDishspecificationinfo()));
					List<DishspecificationinfoEntity> listOfDishspecificationinfo = new ArrayList<DishspecificationinfoEntity>();
					for (DishspecificationinfoEntity dishspecificationinfoEntity : dish
							.getListOfDishspecificationinfo())
					{
						if (dishspecificationinfoEntity.getGgno() == null || dishspecificationinfoEntity
								.getStatus() == 0)
						{
							listOfDishspecificationinfo.add(dishspecificationinfoEntity);
						}
					}
					// if there is any specification for the Dish, we show it
					if(listOfDishspecificationinfo.size()>0)
					{
						dish.setListOfDishspecificationinfo(listOfDishspecificationinfo);
						
						newDishList.add(dish);
					}
				}


			}
			beans.add(categoryServiceMapper
					.mapCategoryEntityToCategory(category));
		}

		return beans;

	}
	
}
