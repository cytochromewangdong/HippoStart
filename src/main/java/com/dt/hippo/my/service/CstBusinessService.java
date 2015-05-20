package com.dt.hippo.my.service;

import java.util.List;

import com.dt.hippo.auto.model.Category;

public interface CstBusinessService
{
	public List<Category> getAllValidCategoryAndDishInfoOfCorp(
			long storeid);
}
