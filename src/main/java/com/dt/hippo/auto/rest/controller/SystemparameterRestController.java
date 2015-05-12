/*
 * Created on 12 五月 2015 ( Time 20:53:08 )
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
import com.dt.hippo.auto.model.Systemparameter;
import com.dt.hippo.auto.business.service.SystemparameterService;
import com.dt.hippo.auto.web.listitem.SystemparameterListItem;

/**
 * Spring MVC controller for 'Systemparameter' management.
 */
@Controller
public class SystemparameterRestController {

	@Resource
	protected SystemparameterService systemparameterService;
	
	@RequestMapping( value="/items/systemparameter",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<SystemparameterListItem> findAllAsListItems() {
		List<Systemparameter> list = systemparameterService.findAll();
		List<SystemparameterListItem> items = new LinkedList<SystemparameterListItem>();
		for ( Systemparameter systemparameter : list ) {
			items.add(new SystemparameterListItem( systemparameter ) );
		}
		return items;
	}
	
	@RequestMapping( value="/systemparameter",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Systemparameter> findAll() {
		return systemparameterService.findAll();
	}

	@RequestMapping( value="/systemparameter/{uid}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Systemparameter findOne(@PathVariable("uid") Integer uid) {
		return systemparameterService.findById(uid);
	}
	
	@RequestMapping( value="/systemparameter",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Systemparameter create(@RequestBody Systemparameter systemparameter) {
		return systemparameterService.create(systemparameter);
	}

	@RequestMapping( value="/systemparameter/{uid}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Systemparameter update(@PathVariable("uid") Integer uid, @RequestBody Systemparameter systemparameter) {
		return systemparameterService.update(systemparameter);
	}

	@RequestMapping( value="/systemparameter/{uid}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("uid") Integer uid) {
		systemparameterService.delete(uid);
	}
	
}
