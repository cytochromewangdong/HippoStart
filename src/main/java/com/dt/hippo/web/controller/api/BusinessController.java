package com.dt.hippo.web.controller.api;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dt.hippo.business.model.com.DishCom;
import com.dt.hippo.my.service.CstBusinessService;


public class BusinessController
{
	@Resource
	CstBusinessService cstBusinessService;
	
	@RequestMapping(value = "/category/{corpid}")
	// , method = RequestMethod.GET
	@ResponseBody
	public DishCom category(@PathVariable("corpid") Long corpid)
	{
		DishCom com = new DishCom();
		com.setCategoryList(cstBusinessService.getAllValidCategoryAndDishInfoOfCorp(corpid));
		return com;
	}
}
