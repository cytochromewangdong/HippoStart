package com.dt.hippo.web.controller.api;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dt.hippo.business.model.com.OrderCom;
import com.dt.hippo.my.service.CstOrderService;
import com.wordnik.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "/api/order")
public class OrderController
{
	@Resource
	private CstOrderService myOrderService;

	@ApiOperation(value = "get the history order list", notes = "Return the latest 200 orders!")
	@RequestMapping(value = "/past/{userId}", method = { RequestMethod.GET })
	@ResponseBody
	public OrderCom pastOrders(
			@PathVariable("userId") Long userId,
			@RequestParam("maxOrderId") Long maxOrderId)
	{
		// TODO, only the user can access its orders.
		OrderCom com = new OrderCom();
		com.setListOfOrder(myOrderService.getPastOrders(userId,
				maxOrderId));
		return com;
	}

	// @JsonView(Views.PublicOrder.class)
	@ApiOperation(value = "submit the order", notes = "The server check the order, and generate new order, if any price is different, it returns the latest price ")
	@RequestMapping(value = "/take", method = { RequestMethod.POST })
	@ResponseBody
	public OrderCom confirmOrder(
			@RequestBody @Valid OrderCom com,
			BindingResult bindingResult)
	{
		// OrderRowBean o = new OrderRowBean();
		// o.setAmount(100);
		// o.setDishType(1);
		// o.setPriceOrValue(100l);
		// o.setType(1);
		// List<OrderRowBean> nl= new ArrayList<>();
		// nl.add(o);
		// com.setInternal("dfdfdf");
		// com.settPublic("eeeeeeeeeee");
		// com.setListOfItemOrdered(Arrays.asList(o));
		// ValidationUtils
		// bindingResult.re
		if (bindingResult.hasErrors())
		{
			com.setResult(-1);
//			com.setError(bindingResult.getAllErrors());
			com.setAllError(bindingResult.getAllErrors());
		}
		return com;
	}

}
