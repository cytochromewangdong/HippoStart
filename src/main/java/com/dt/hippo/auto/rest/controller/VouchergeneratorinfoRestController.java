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
import com.dt.hippo.auto.model.Vouchergeneratorinfo;
import com.dt.hippo.auto.business.service.VouchergeneratorinfoService;
import com.dt.hippo.auto.web.listitem.VouchergeneratorinfoListItem;

/**
 * Spring MVC controller for 'Vouchergeneratorinfo' management.
 */
@Controller
@RequestMapping("/api")
public class VouchergeneratorinfoRestController {

	@Resource
	protected VouchergeneratorinfoService vouchergeneratorinfoService;
	
	@RequestMapping( value="/items/vouchergeneratorinfo",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<VouchergeneratorinfoListItem> findAllAsListItems() {
		List<Vouchergeneratorinfo> list = vouchergeneratorinfoService.findAll();
		List<VouchergeneratorinfoListItem> items = new LinkedList<VouchergeneratorinfoListItem>();
		for ( Vouchergeneratorinfo vouchergeneratorinfo : list ) {
			items.add(new VouchergeneratorinfoListItem( vouchergeneratorinfo ) );
		}
		return items;
	}
	
	@RequestMapping( value="/vouchergeneratorinfo",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Vouchergeneratorinfo> findAll() {
		return vouchergeneratorinfoService.findAll();
	}

	@RequestMapping( value="/vouchergeneratorinfo/{uid}/{value}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Vouchergeneratorinfo findOne(@PathVariable("uid") Integer uid, @PathVariable("value") Integer value) {
		return vouchergeneratorinfoService.findById(uid, value);
	}
	
	@RequestMapping( value="/vouchergeneratorinfo",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Vouchergeneratorinfo create(@RequestBody Vouchergeneratorinfo vouchergeneratorinfo) {
		return vouchergeneratorinfoService.create(vouchergeneratorinfo);
	}

	@RequestMapping( value="/vouchergeneratorinfo/{uid}/{value}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Vouchergeneratorinfo update(@PathVariable("uid") Integer uid, @PathVariable("value") Integer value, @RequestBody Vouchergeneratorinfo vouchergeneratorinfo) {
		return vouchergeneratorinfoService.update(vouchergeneratorinfo);
	}

	@RequestMapping( value="/vouchergeneratorinfo/{uid}/{value}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("uid") Integer uid, @PathVariable("value") Integer value) {
		vouchergeneratorinfoService.delete(uid, value);
	}
	
}
