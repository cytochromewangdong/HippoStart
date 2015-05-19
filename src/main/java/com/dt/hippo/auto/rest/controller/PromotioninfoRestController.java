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
import com.dt.hippo.auto.model.Promotioninfo;
import com.dt.hippo.auto.business.service.PromotioninfoService;
import com.dt.hippo.auto.web.listitem.PromotioninfoListItem;

/**
 * Spring MVC controller for 'Promotioninfo' management.
 */
@Controller
@RequestMapping("/api")
public class PromotioninfoRestController {

	@Resource
	protected PromotioninfoService promotioninfoService;
	
	@RequestMapping( value="/items/promotioninfo",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<PromotioninfoListItem> findAllAsListItems() {
		List<Promotioninfo> list = promotioninfoService.findAll();
		List<PromotioninfoListItem> items = new LinkedList<PromotioninfoListItem>();
		for ( Promotioninfo promotioninfo : list ) {
			items.add(new PromotioninfoListItem( promotioninfo ) );
		}
		return items;
	}
	
	@RequestMapping( value="/promotioninfo",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Promotioninfo> findAll() {
		return promotioninfoService.findAll();
	}

	@RequestMapping( value="/promotioninfo/{uid}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Promotioninfo findOne(@PathVariable("uid") Long uid) {
		return promotioninfoService.findById(uid);
	}
	
	@RequestMapping( value="/promotioninfo",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Promotioninfo create(@RequestBody Promotioninfo promotioninfo) {
		return promotioninfoService.create(promotioninfo);
	}

	@RequestMapping( value="/promotioninfo/{uid}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Promotioninfo update(@PathVariable("uid") Long uid, @RequestBody Promotioninfo promotioninfo) {
		return promotioninfoService.update(promotioninfo);
	}

	@RequestMapping( value="/promotioninfo/{uid}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("uid") Long uid) {
		promotioninfoService.delete(uid);
	}
	
}
