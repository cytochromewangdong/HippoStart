/**
 * Created on Dec 23, 2011
 */
package com.dt.hippo.web.test;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dt.hippo.business.base.BaseController;
import com.dt.hippo.core.base.BaseResult;
import com.dt.hippo.cst.ErroConstant;
import com.dt.hippo.my.service.MyComboinfoService;

/**
 * @author Clarence
 *
 */
//@RequestMapping("/contacts")
@Controller
public class ContactController extends BaseController  {

	final Logger logger = LoggerFactory.getLogger(ContactController.class);	
	
	@Autowired
	MessageSource messageSource;
	
////	@Resource//(name="contactService")
//	@Autowired
//	private MyContactService myContactService;
//	
//	@RequestMapping(method = RequestMethod.GET)
//	public String list(Model uiModel) {
//		logger.info("Listing contacts");	
//		
//		List<Contact> contacts = myContactService.findContactByFirstName("D%");
//		if (contacts.size() > 0) {
//			Contact c = contacts.get(0);
//			List<Hobby> hobbyList = c.getListOfHobby();
//			System.out.println(hobbyList.size());
//		}
//		uiModel.addAttribute("contacts", contacts);
//		
////		logger.info("No. of contacts: " + contacts.size());
//		
//		return "contacts/list";
//	}
//	
//	@RequestMapping(name = "/login", method = RequestMethod.GET)
//	public void login(Model uiModel) {
//
//	}
//	@RequestMapping(value = "/login", method = RequestMethod.GET, consumes = "application/json")
//	@ResponseBody
//	public BaseResult login(HttpServletRequest request) {
//		return new BaseResult(ErroConstant.NOT_LOGIN, this.getNotLoginError(),
//				"/login");
//	}
	@Resource 
	private MyComboinfoService myComboinfoService;
	@RequestMapping(value = "/test88")
	// , method = RequestMethod.GET
	@ResponseBody
	public BaseResult test(HttpServletRequest request) {
		myComboinfoService.createComboInfo();
		return new BaseResult(ErroConstant.NOT_LOGIN, "123",
				"/register");
	}
}
