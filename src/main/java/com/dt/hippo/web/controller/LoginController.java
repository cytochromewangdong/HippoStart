package com.dt.hippo.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dt.hippo.auto.data.repository.jpa.CategoryJpaRepository;
import com.dt.hippo.auto.model.Account;
import com.dt.hippo.business.common.SequenceService;
import com.dt.hippo.core.base.BaseController;
import com.dt.hippo.core.base.BaseResult;
import com.dt.hippo.cst.ErroConstant;
import com.dt.hippo.my.service.MyComboinfoService;
import com.dt.hippo.service.CustomUserDetailsService;

@Controller
public class LoginController extends BaseController
{

	@Resource
	private CustomUserDetailsService customUserDetailsService;

	// @RequestMapping(name = "/login", method = RequestMethod.GET)
	// public void login(Model uiModel) {
	//
	// }
	//
	// @RequestMapping(value = "/login", method = RequestMethod.GET, consumes =
	// "application/json")
	// @ResponseBody
	// public BaseResult login(HttpServletRequest request) {
	// return new BaseResult(ErroConstant.NOT_LOGIN, this.getNotLoginError(),
	// "/login");
	// }

	@RequestMapping(value = "/register")
	// , method = RequestMethod.GET
	@ResponseBody
	public BaseResult register(HttpServletRequest request)
	{
		Account user = new Account();
		user.setUsername("wangdong");
		user.setPassword("234");
		// Set<Role> roles = new HashSet<Role>();
		// roles.add(new Role("ROLE_ADMIN"));
		// roles.add(new Role("ROLE_USER"));
		// user.setRoles(roles);
		// authenticateUserAndSetSession(user, request);
		customUserDetailsService
				.authenticateUserWithoutPasswordAndSetSession(
						user, request);
		return new BaseResult(ErroConstant.NOT_LOGIN,
				this.getNotLoginError(), "/register");
	}

	@Resource
	private MyComboinfoService myComboinfoService;

	@Resource
	private SequenceService customerServiceProxy;

	@Resource
	private CategoryJpaRepository categoryJpaRepository;

	@RequestMapping(value = "/wwdd")
	// , method = RequestMethod.GET
	@ResponseBody
	public BaseResult test(HttpServletRequest request)
	{
		// myComboinfoService.createComboInfo();
//		categoryJpaRepository.findWhatIWant(1);
//		categoryJpaRepository.findByName("test"); 
//		customerServiceProxy.getSeqence();
		return new BaseResult(ErroConstant.NOT_LOGIN,
				this.getNotLoginError(), "/register");
	}

	// @RequestMapping(value = "/test")
	// // , method = RequestMethod.GET
	// @ResponseBody
	// public UserInter test(MyUser request) {
	// return request;
	// }
}
