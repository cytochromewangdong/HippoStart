/*
 * Created on 18 五月 2015 ( Time 11:12:59 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.auto.rest.controller;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.dt.hippo.auto.model.Payment;
import com.dt.hippo.auto.business.service.PaymentService;
import com.dt.hippo.auto.web.listitem.PaymentListItem;

/**
 * Spring MVC controller for 'Payment' management.
 */
@Controller
@RequestMapping("/api")
public class PaymentRestController {

	@Resource
	protected PaymentService paymentService;
	
	@RequestMapping( value="/items/payment",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<PaymentListItem> findAllAsListItems() {
		List<Payment> list = paymentService.findAll();
		List<PaymentListItem> items = new LinkedList<PaymentListItem>();
		for ( Payment payment : list ) {
			items.add(new PaymentListItem( payment ) );
		}
		return items;
	}
	
	@RequestMapping( value="/payment",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Payment> findAll() {
		return paymentService.findAll();
	}

	@RequestMapping( value="/payment/{uid}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Payment findOne(@PathVariable("uid") Long uid) {
		return paymentService.findById(uid);
	}
	
	@RequestMapping( value="/payment",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Payment create(@RequestBody Payment payment) {
		return paymentService.create(payment);
	}

	@RequestMapping( value="/payment/{uid}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Payment update(@PathVariable("uid") Long uid, @RequestBody Payment payment) {
		return paymentService.update(payment);
	}

	@RequestMapping( value="/payment/{uid}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("uid") Long uid) {
		paymentService.delete(uid);
	}
	
}
