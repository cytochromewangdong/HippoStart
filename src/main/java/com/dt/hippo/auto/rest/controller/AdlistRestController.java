/*
 * Created on 30 五月 2015 ( Time 18:22:34 )
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
import com.dt.hippo.auto.model.Adlist;
import com.dt.hippo.auto.business.service.AdlistService;
import com.dt.hippo.auto.web.listitem.AdlistListItem;

/**
 * Spring MVC controller for 'Adlist' management.
 */
@Controller
@RequestMapping("/api")
public class AdlistRestController {

	@Resource
	protected AdlistService adlistService;
	
	@RequestMapping( value="/items/adlist",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<AdlistListItem> findAllAsListItems() {
		List<Adlist> list = adlistService.findAll();
		List<AdlistListItem> items = new LinkedList<AdlistListItem>();
		for ( Adlist adlist : list ) {
			items.add(new AdlistListItem( adlist ) );
		}
		return items;
	}
	
	@RequestMapping( value="/adlist",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Adlist> findAll() {
		return adlistService.findAll();
	}

	@RequestMapping( value="/adlist/{uid}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Adlist findOne(@PathVariable("uid") Long uid) {
		return adlistService.findById(uid);
	}
	
	@RequestMapping( value="/adlist",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Adlist create(@RequestBody Adlist adlist) {
		return adlistService.create(adlist);
	}

	@RequestMapping( value="/adlist/{uid}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Adlist update(@PathVariable("uid") Long uid, @RequestBody Adlist adlist) {
		return adlistService.update(adlist);
	}

	@RequestMapping( value="/adlist/{uid}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("uid") Long uid) {
		adlistService.delete(uid);
	}
	
}
