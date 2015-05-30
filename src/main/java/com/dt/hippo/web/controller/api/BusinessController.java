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
import com.wordnik.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "/api")
public class BusinessController
{
	@Resource
	CstBusinessService cstBusinessService;

	@Resource
	TestAoP testAoP;

	@ApiOperation(value = "get the category list by store id", notes = "Return all past orders as well as the menus, prices, vouchers")
	@RequestMapping(value = "/dish/{storeid}", method = {
			RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public DishCom store(@PathVariable("storeid") Long storeid)
	{
		DishCom com = new DishCom();
//		com.setCategoryList(cstBusinessService
//				.getStoreInfo(storeid).getCategoryList());
		cstBusinessService.getStoreinfoForUser(storeid);
		return com;
	}
}
