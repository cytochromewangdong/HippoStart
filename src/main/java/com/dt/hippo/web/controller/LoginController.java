package com.dt.hippo.web.controller;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dt.hippo.con.ErroConstant;
import com.dt.hippo.core.base.BaseController;
import com.dt.hippo.core.base.BaseResult;
import com.dt.hippo.datajpa.model.jpa.Role;
import com.dt.hippo.datajpa.model.jpa.User;
import com.dt.hippo.service.CustomUserDetailsService;

@Controller
public class LoginController extends BaseController {

	@Resource
	private CustomUserDetailsService customUserDetailsService;
	
	@RequestMapping(name = "/login", method = RequestMethod.GET)
	public void login(Model uiModel) {

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET, consumes = "application/json")
	@ResponseBody
	public BaseResult login(HttpServletRequest request) {
		return new BaseResult(ErroConstant.NOT_LOGIN, this.getNotLoginError(),
				"/login");
	}
	
	@RequestMapping(value = "/register")//, method = RequestMethod.GET
	@ResponseBody
	public BaseResult register(HttpServletRequest request) {
		User user = new User();
		user.setName("wangdong");
		user.setPassword("234");
		Set<Role> roles = new HashSet<Role>();
		roles.add(new Role("ROLE_ADMIN"));
		roles.add(new Role("ROLE_USER"));
		user.setRoles(roles);
		//authenticateUserAndSetSession(user, request);
		customUserDetailsService.authenticateUserWithoutPasswordAndSetSession(user, request);
		return new BaseResult(ErroConstant.NOT_LOGIN, this.getNotLoginError(),
				"/register");
	}

}
