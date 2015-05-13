/*
 * Created on 13 五月 2015 ( Time 21:15:33 )
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
import com.dt.hippo.auto.model.Verifyrecord;
import com.dt.hippo.auto.business.service.VerifyrecordService;
import com.dt.hippo.auto.web.listitem.VerifyrecordListItem;

/**
 * Spring MVC controller for 'Verifyrecord' management.
 */
@Controller
public class VerifyrecordRestController {

	@Resource
	protected VerifyrecordService verifyrecordService;
	
	@RequestMapping( value="/items/verifyrecord",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<VerifyrecordListItem> findAllAsListItems() {
		List<Verifyrecord> list = verifyrecordService.findAll();
		List<VerifyrecordListItem> items = new LinkedList<VerifyrecordListItem>();
		for ( Verifyrecord verifyrecord : list ) {
			items.add(new VerifyrecordListItem( verifyrecord ) );
		}
		return items;
	}
	
	@RequestMapping( value="/verifyrecord",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Verifyrecord> findAll() {
		return verifyrecordService.findAll();
	}

	@RequestMapping( value="/verifyrecord/{uid}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Verifyrecord findOne(@PathVariable("uid") Long uid) {
		return verifyrecordService.findById(uid);
	}
	
	@RequestMapping( value="/verifyrecord",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Verifyrecord create(@RequestBody Verifyrecord verifyrecord) {
		return verifyrecordService.create(verifyrecord);
	}

	@RequestMapping( value="/verifyrecord/{uid}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Verifyrecord update(@PathVariable("uid") Long uid, @RequestBody Verifyrecord verifyrecord) {
		return verifyrecordService.update(verifyrecord);
	}

	@RequestMapping( value="/verifyrecord/{uid}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("uid") Long uid) {
		verifyrecordService.delete(uid);
	}
	
}