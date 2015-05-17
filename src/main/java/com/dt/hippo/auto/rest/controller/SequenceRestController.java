/*
 * Created on 13 五月 2015 ( Time 21:15:31 )
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
import com.dt.hippo.auto.model.Sequence;
import com.dt.hippo.auto.business.service.SequenceService;
import com.dt.hippo.auto.web.listitem.SequenceListItem;

/**
 * Spring MVC controller for 'Sequence' management.
 */
@Controller
@RequestMapping("/rest")
public class SequenceRestController {

	@Resource
	protected SequenceService sequenceService;
	
	@RequestMapping( value="/items/sequence",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<SequenceListItem> findAllAsListItems() {
		List<Sequence> list = sequenceService.findAll();
		List<SequenceListItem> items = new LinkedList<SequenceListItem>();
		for ( Sequence sequence : list ) {
			items.add(new SequenceListItem( sequence ) );
		}
		return items;
	}
	
	@RequestMapping( value="/sequence",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Sequence> findAll() {
		return sequenceService.findAll();
	}

	@RequestMapping( value="/sequence/{uid}/{keyword}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Sequence findOne(@PathVariable("uid") Long uid, @PathVariable("keyword") String keyword) {
		return sequenceService.findById(uid, keyword);
	}
	
	@RequestMapping( value="/sequence",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Sequence create(@RequestBody Sequence sequence) {
		return sequenceService.create(sequence);
	}

	@RequestMapping( value="/sequence/{uid}/{keyword}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Sequence update(@PathVariable("uid") Long uid, @PathVariable("keyword") String keyword, @RequestBody Sequence sequence) {
		return sequenceService.update(sequence);
	}

	@RequestMapping( value="/sequence/{uid}/{keyword}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("uid") Long uid, @PathVariable("keyword") String keyword) {
		sequenceService.delete(uid, keyword);
	}
	
}
