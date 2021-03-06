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
import com.dt.hippo.auto.model.Cateringcorpinfo;
import com.dt.hippo.auto.business.service.CateringcorpinfoService;
import com.dt.hippo.auto.web.listitem.CateringcorpinfoListItem;

/**
 * Spring MVC controller for 'Cateringcorpinfo' management.
 */
@Controller
@RequestMapping("/api")
public class CateringcorpinfoRestController {

	@Resource
	protected CateringcorpinfoService cateringcorpinfoService;
	
	@RequestMapping( value="/items/cateringcorpinfo",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<CateringcorpinfoListItem> findAllAsListItems() {
		List<Cateringcorpinfo> list = cateringcorpinfoService.findAll();
		List<CateringcorpinfoListItem> items = new LinkedList<CateringcorpinfoListItem>();
		for ( Cateringcorpinfo cateringcorpinfo : list ) {
			items.add(new CateringcorpinfoListItem( cateringcorpinfo ) );
		}
		return items;
	}
	
	@RequestMapping( value="/cateringcorpinfo",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Cateringcorpinfo> findAll() {
		return cateringcorpinfoService.findAll();
	}

	@RequestMapping( value="/cateringcorpinfo/{uid}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Cateringcorpinfo findOne(@PathVariable("uid") Long uid) {
		return cateringcorpinfoService.findById(uid);
	}
	
	@RequestMapping( value="/cateringcorpinfo",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Cateringcorpinfo create(@RequestBody Cateringcorpinfo cateringcorpinfo) {
		return cateringcorpinfoService.create(cateringcorpinfo);
	}

	@RequestMapping( value="/cateringcorpinfo/{uid}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Cateringcorpinfo update(@PathVariable("uid") Long uid, @RequestBody Cateringcorpinfo cateringcorpinfo) {
		return cateringcorpinfoService.update(cateringcorpinfo);
	}

	@RequestMapping( value="/cateringcorpinfo/{uid}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("uid") Long uid) {
		cateringcorpinfoService.delete(uid);
	}
	
}
