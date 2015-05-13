/*
 * Created on 13 五月 2015 ( Time 21:15:23 )
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
import com.dt.hippo.auto.model.Category;
import com.dt.hippo.auto.business.service.CategoryService;
import com.dt.hippo.auto.web.listitem.CategoryListItem;

/**
 * Spring MVC controller for 'Category' management.
 */
@Controller
public class CategoryRestController {

	@Resource
	protected CategoryService categoryService;
	
	@RequestMapping( value="/items/category",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<CategoryListItem> findAllAsListItems() {
		List<Category> list = categoryService.findAll();
		List<CategoryListItem> items = new LinkedList<CategoryListItem>();
		for ( Category category : list ) {
			items.add(new CategoryListItem( category ) );
		}
		return items;
	}
	
	@RequestMapping( value="/category",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Category> findAll() {
		return categoryService.findAll();
	}

	@RequestMapping( value="/category/{corpid}/{uid}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Category findOne(@PathVariable("corpid") Long corpid, @PathVariable("uid") String uid) {
		return categoryService.findById(corpid, uid);
	}
	
	@RequestMapping( value="/category",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Category create(@RequestBody Category category) {
		return categoryService.create(category);
	}

	@RequestMapping( value="/category/{corpid}/{uid}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Category update(@PathVariable("corpid") Long corpid, @PathVariable("uid") String uid, @RequestBody Category category) {
		return categoryService.update(category);
	}

	@RequestMapping( value="/category/{corpid}/{uid}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("corpid") Long corpid, @PathVariable("uid") String uid) {
		categoryService.delete(corpid, uid);
	}
	
}