/*
 * Created on 18 五月 2015 ( Time 11:12:58 )
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
import com.dt.hippo.auto.model.Dishinfo;
import com.dt.hippo.auto.business.service.DishinfoService;
import com.dt.hippo.auto.web.listitem.DishinfoListItem;

/**
 * Spring MVC controller for 'Dishinfo' management.
 */
@Controller
@RequestMapping("/api")
public class DishinfoRestController {

	@Resource
	protected DishinfoService dishinfoService;
	
	@RequestMapping( value="/items/dishinfo",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<DishinfoListItem> findAllAsListItems() {
		List<Dishinfo> list = dishinfoService.findAll();
		List<DishinfoListItem> items = new LinkedList<DishinfoListItem>();
		for ( Dishinfo dishinfo : list ) {
			items.add(new DishinfoListItem( dishinfo ) );
		}
		return items;
	}
	
	@RequestMapping( value="/dishinfo",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Dishinfo> findAll() {
		return dishinfoService.findAll();
	}

	@RequestMapping( value="/dishinfo/{uid}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Dishinfo findOne(@PathVariable("uid") Long uid) {
		return dishinfoService.findById(uid);
	}
	
	@RequestMapping( value="/dishinfo",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Dishinfo create(@RequestBody Dishinfo dishinfo) {
		return dishinfoService.create(dishinfo);
	}

	@RequestMapping( value="/dishinfo/{uid}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Dishinfo update(@PathVariable("uid") Long uid, @RequestBody Dishinfo dishinfo) {
		return dishinfoService.update(dishinfo);
	}

	@RequestMapping( value="/dishinfo/{uid}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("uid") Long uid) {
		dishinfoService.delete(uid);
	}
	
}
