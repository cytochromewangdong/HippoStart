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
import com.dt.hippo.auto.model.Administrator;
import com.dt.hippo.auto.business.service.AdministratorService;
import com.dt.hippo.auto.web.listitem.AdministratorListItem;

/**
 * Spring MVC controller for 'Administrator' management.
 */
@Controller
@RequestMapping("/api")
public class AdministratorRestController {

	@Resource
	protected AdministratorService administratorService;
	
	@RequestMapping( value="/items/administrator",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<AdministratorListItem> findAllAsListItems() {
		List<Administrator> list = administratorService.findAll();
		List<AdministratorListItem> items = new LinkedList<AdministratorListItem>();
		for ( Administrator administrator : list ) {
			items.add(new AdministratorListItem( administrator ) );
		}
		return items;
	}
	
	@RequestMapping( value="/administrator",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Administrator> findAll() {
		return administratorService.findAll();
	}

	@RequestMapping( value="/administrator/{uid}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Administrator findOne(@PathVariable("uid") Long uid) {
		return administratorService.findById(uid);
	}
	
	@RequestMapping( value="/administrator",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Administrator create(@RequestBody Administrator administrator) {
		return administratorService.create(administrator);
	}

	@RequestMapping( value="/administrator/{uid}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Administrator update(@PathVariable("uid") Long uid, @RequestBody Administrator administrator) {
		return administratorService.update(administrator);
	}

	@RequestMapping( value="/administrator/{uid}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("uid") Long uid) {
		administratorService.delete(uid);
	}
	
}
