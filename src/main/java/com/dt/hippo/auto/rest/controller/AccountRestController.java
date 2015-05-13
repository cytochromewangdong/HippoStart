/*
 * Created on 13 五月 2015 ( Time 21:15:22 )
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
import com.dt.hippo.auto.model.Account;
import com.dt.hippo.auto.business.service.AccountService;
import com.dt.hippo.auto.web.listitem.AccountListItem;

/**
 * Spring MVC controller for 'Account' management.
 */
@Controller
public class AccountRestController {

	@Resource
	protected AccountService accountService;
	
	@RequestMapping( value="/items/account",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<AccountListItem> findAllAsListItems() {
		List<Account> list = accountService.findAll();
		List<AccountListItem> items = new LinkedList<AccountListItem>();
		for ( Account account : list ) {
			items.add(new AccountListItem( account ) );
		}
		return items;
	}
	
	@RequestMapping( value="/account",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Account> findAll() {
		return accountService.findAll();
	}

	@RequestMapping( value="/account/{uid}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Account findOne(@PathVariable("uid") Long uid) {
		return accountService.findById(uid);
	}
	
	@RequestMapping( value="/account",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Account create(@RequestBody Account account) {
		return accountService.create(account);
	}

	@RequestMapping( value="/account/{uid}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Account update(@PathVariable("uid") Long uid, @RequestBody Account account) {
		return accountService.update(account);
	}

	@RequestMapping( value="/account/{uid}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("uid") Long uid) {
		accountService.delete(uid);
	}
	
}