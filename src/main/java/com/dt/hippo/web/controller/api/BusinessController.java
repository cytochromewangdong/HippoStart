package com.dt.hippo.web.controller.api;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dt.hippo.business.TestAoP;
import com.dt.hippo.business.model.com.DishCom;
import com.dt.hippo.my.service.CstBusinessService;

@Controller
@RequestMapping(value = "/api")
public class BusinessController
{
	@Resource
	CstBusinessService cstBusinessService;

	@Resource
	TestAoP testAoP;

	@RequestMapping(value = "/dish/{corpid}", method = {
			RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public DishCom category(@PathVariable("corpid") Long corpid)
	{
		DishCom com = new DishCom();
		com.setCategoryList(cstBusinessService
				.getAllValidCategoryAndDishInfoOfCorp(corpid));
		return com;
	}
}
