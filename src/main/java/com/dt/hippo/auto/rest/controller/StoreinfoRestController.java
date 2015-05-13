/*
 * Created on 13 五月 2015 ( Time 21:15:32 )
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
import com.dt.hippo.auto.model.Storeinfo;
import com.dt.hippo.auto.business.service.StoreinfoService;
import com.dt.hippo.auto.web.listitem.StoreinfoListItem;

/**
 * Spring MVC controller for 'Storeinfo' management.
 */
@Controller
public class StoreinfoRestController {

	@Resource
	protected StoreinfoService storeinfoService;
	
	@RequestMapping( value="/items/storeinfo",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<StoreinfoListItem> findAllAsListItems() {
		List<Storeinfo> list = storeinfoService.findAll();
		List<StoreinfoListItem> items = new LinkedList<StoreinfoListItem>();
		for ( Storeinfo storeinfo : list ) {
			items.add(new StoreinfoListItem( storeinfo ) );
		}
		return items;
	}
	
	@RequestMapping( value="/storeinfo",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Storeinfo> findAll() {
		return storeinfoService.findAll();
	}

	@RequestMapping( value="/storeinfo/{uid}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Storeinfo findOne(@PathVariable("uid") Long uid) {
		return storeinfoService.findById(uid);
	}
	
	@RequestMapping( value="/storeinfo",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Storeinfo create(@RequestBody Storeinfo storeinfo) {
		return storeinfoService.create(storeinfo);
	}

	@RequestMapping( value="/storeinfo/{uid}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Storeinfo update(@PathVariable("uid") Long uid, @RequestBody Storeinfo storeinfo) {
		return storeinfoService.update(storeinfo);
	}

	@RequestMapping( value="/storeinfo/{uid}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("uid") Long uid) {
		storeinfoService.delete(uid);
	}
	
}
