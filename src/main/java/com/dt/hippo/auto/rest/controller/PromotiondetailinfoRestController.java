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
import com.dt.hippo.auto.model.Promotiondetailinfo;
import com.dt.hippo.auto.business.service.PromotiondetailinfoService;
import com.dt.hippo.auto.web.listitem.PromotiondetailinfoListItem;

/**
 * Spring MVC controller for 'Promotiondetailinfo' management.
 */
@Controller
@RequestMapping("/api")
public class PromotiondetailinfoRestController {

	@Resource
	protected PromotiondetailinfoService promotiondetailinfoService;
	
	@RequestMapping( value="/items/promotiondetailinfo",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<PromotiondetailinfoListItem> findAllAsListItems() {
		List<Promotiondetailinfo> list = promotiondetailinfoService.findAll();
		List<PromotiondetailinfoListItem> items = new LinkedList<PromotiondetailinfoListItem>();
		for ( Promotiondetailinfo promotiondetailinfo : list ) {
			items.add(new PromotiondetailinfoListItem( promotiondetailinfo ) );
		}
		return items;
	}
	
	@RequestMapping( value="/promotiondetailinfo",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Promotiondetailinfo> findAll() {
		return promotiondetailinfoService.findAll();
	}

	@RequestMapping( value="/promotiondetailinfo/{uid}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Promotiondetailinfo findOne(@PathVariable("uid") Long uid) {
		return promotiondetailinfoService.findById(uid);
	}
	
	@RequestMapping( value="/promotiondetailinfo",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Promotiondetailinfo create(@RequestBody Promotiondetailinfo promotiondetailinfo) {
		return promotiondetailinfoService.create(promotiondetailinfo);
	}

	@RequestMapping( value="/promotiondetailinfo/{uid}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Promotiondetailinfo update(@PathVariable("uid") Long uid, @RequestBody Promotiondetailinfo promotiondetailinfo) {
		return promotiondetailinfoService.update(promotiondetailinfo);
	}

	@RequestMapping( value="/promotiondetailinfo/{uid}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("uid") Long uid) {
		promotiondetailinfoService.delete(uid);
	}
	
}
