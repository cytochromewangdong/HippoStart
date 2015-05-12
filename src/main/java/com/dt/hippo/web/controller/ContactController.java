/**
 * Created on Dec 23, 2011
 */
package com.dt.hippo.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Clarence
 *
 */
@RequestMapping("/contacts")
@Controller
public class ContactController {

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
	
}
