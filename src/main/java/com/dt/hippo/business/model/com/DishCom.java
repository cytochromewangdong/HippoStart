package com.dt.hippo.business.model.com;

import java.util.List;

import com.dt.hippo.auto.model.Category;
import com.dt.hippo.core.base.BaseResult;

public class DishCom extends BaseResult
{
	private List<Category> categoryList;

	public List<Category> getCategoryList()
	{
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList)
	{
		this.categoryList = categoryList;
	}

}
