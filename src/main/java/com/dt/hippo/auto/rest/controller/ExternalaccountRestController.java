/*
 * Created on 30 五月 2015 ( Time 21:07:38 )
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
import com.dt.hippo.auto.model.Externalaccount;
import com.dt.hippo.auto.business.service.ExternalaccountService;
import com.dt.hippo.auto.web.listitem.ExternalaccountListItem;

/**
 * Spring MVC controller for 'Externalaccount' management.
 */
@Controller
@RequestMapping("/api")
public class ExternalaccountRestController {

	@Resource
	protected ExternalaccountService externalaccountService;
	
	@RequestMapping( value="/items/externalaccount",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<ExternalaccountListItem> findAllAsListItems() {
		List<Externalaccount> list = externalaccountService.findAll();
		List<ExternalaccountListItem> items = new LinkedList<ExternalaccountListItem>();
		for ( Externalaccount externalaccount : list ) {
			items.add(new ExternalaccountListItem( externalaccount ) );
		}
		return items;
	}
	
	@RequestMapping( value="/externalaccount",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Externalaccount> findAll() {
		return externalaccountService.findAll();
	}

	@RequestMapping( value="/externalaccount/{uid}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Externalaccount findOne(@PathVariable("uid") Long uid) {
		return externalaccountService.findById(uid);
	}
	
	@RequestMapping( value="/externalaccount",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Externalaccount create(@RequestBody Externalaccount externalaccount) {
		return externalaccountService.create(externalaccount);
	}

	@RequestMapping( value="/externalaccount/{uid}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Externalaccount update(@PathVariable("uid") Long uid, @RequestBody Externalaccount externalaccount) {
		return externalaccountService.update(externalaccount);
	}

	@RequestMapping( value="/externalaccount/{uid}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("uid") Long uid) {
		externalaccountService.delete(uid);
	}
	
}
