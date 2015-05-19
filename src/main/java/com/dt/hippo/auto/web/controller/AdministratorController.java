/*
 * Created on 18 五月 2015 ( Time 11:07:08 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.auto.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//--- Common classes
import com.dt.hippo.auto.web.common.AbstractController;
import com.dt.hippo.auto.web.common.FormMode;
import com.dt.hippo.auto.web.common.Message;
import com.dt.hippo.auto.web.common.MessageType;

//--- Entities
import com.dt.hippo.auto.model.Administrator;

//--- Services 
import com.dt.hippo.auto.business.service.AdministratorService;


/**
 * Spring MVC controller for 'Administrator' management.
 */
@Controller
@RequestMapping("/administrator")
public class AdministratorController extends AbstractController {

	//--- Variables names ( to be used in JSP with Expression Language )
	private static final String MAIN_ENTITY_NAME = "administrator";
	private static final String MAIN_LIST_NAME   = "list";

	//--- JSP pages names ( View name in the MVC model )
	private static final String JSP_FORM   = "administrator/form";
	private static final String JSP_LIST   = "administrator/list";

	//--- SAVE ACTION ( in the HTML form )
	private static final String SAVE_ACTION_CREATE   = "/administrator/create";
	private static final String SAVE_ACTION_UPDATE   = "/administrator/update";

	//--- Main entity service
	@Resource
    protected AdministratorService administratorService; // Injected by Spring
	//--- Other service(s)

	//--------------------------------------------------------------------------------------
	/**
	 * Default constructor
	 */
	public AdministratorController() {
		super(AdministratorController.class, MAIN_ENTITY_NAME );
		log("AdministratorController created.");
	}

	//--------------------------------------------------------------------------------------
	// Spring MVC model management
	//--------------------------------------------------------------------------------------

	/**
	 * Populates the Spring MVC model with the given entity and eventually other useful data
	 * @param model
	 * @param administrator
	 */
	private void populateModel(Model model, Administrator administrator, FormMode formMode) {
		//--- Main entity
		model.addAttribute(MAIN_ENTITY_NAME, administrator);
		if ( formMode == FormMode.CREATE ) {
			model.addAttribute(MODE, MODE_CREATE); // The form is in "create" mode
			model.addAttribute(SAVE_ACTION, SAVE_ACTION_CREATE); 			
			//--- Other data useful in this screen in "create" mode (all fields)
		}
		else if ( formMode == FormMode.UPDATE ) {
			model.addAttribute(MODE, MODE_UPDATE); // The form is in "update" mode
			model.addAttribute(SAVE_ACTION, SAVE_ACTION_UPDATE); 			
			//--- Other data useful in this screen in "update" mode (only non-pk fields)
		}
	}

	//--------------------------------------------------------------------------------------
	// Request mapping
	//--------------------------------------------------------------------------------------
	/**
	 * Shows a list with all the occurrences of Administrator found in the database
	 * @param model Spring MVC model
	 * @return
	 */
	@RequestMapping()
	public String list(Model model) {
		log("Action 'list'");
		List<Administrator> list = administratorService.findAll();
		model.addAttribute(MAIN_LIST_NAME, list);		
		return JSP_LIST;
	}

	/**
	 * Shows a form page in order to create a new Administrator
	 * @param model Spring MVC model
	 * @return
	 */
	@RequestMapping("/form")
	public String formForCreate(Model model) {
		log("Action 'formForCreate'");
		//--- Populates the model with a new instance
		Administrator administrator = new Administrator();	
		populateModel( model, administrator, FormMode.CREATE);
		return JSP_FORM;
	}

	/**
	 * Shows a form page in order to update an existing Administrator
	 * @param model Spring MVC model
	 * @param uid  primary key element
	 * @return
	 */
	@RequestMapping(value = "/form/{uid}")
	public String formForUpdate(Model model, @PathVariable("uid") Long uid ) {
		log("Action 'formForUpdate'");
		//--- Search the entity by its primary key and stores it in the model 
		Administrator administrator = administratorService.findById(uid);
		populateModel( model, administrator, FormMode.UPDATE);		
		return JSP_FORM;
	}

	/**
	 * 'CREATE' action processing. <br>
	 * This action is based on the 'Post/Redirect/Get (PRG)' pattern, so it ends by 'http redirect'<br>
	 * @param administrator  entity to be created
	 * @param bindingResult Spring MVC binding result
	 * @param model Spring MVC model
	 * @param redirectAttributes Spring MVC redirect attributes
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "/create" ) // GET or POST
	public String create(@Valid Administrator administrator, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes, HttpServletRequest httpServletRequest) {
		log("Action 'create'");
		try {
			if (!bindingResult.hasErrors()) {
				Administrator administratorCreated = administratorService.create(administrator); 
				model.addAttribute(MAIN_ENTITY_NAME, administratorCreated);

				//---
				messageHelper.addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
				return redirectToForm(httpServletRequest, administrator.getUid() );
			} else {
				populateModel( model, administrator, FormMode.CREATE);
				return JSP_FORM;
			}
		} catch(Exception e) {
			log("Action 'create' : Exception - " + e.getMessage() );
			messageHelper.addException(model, "administrator.error.create", e);
			populateModel( model, administrator, FormMode.CREATE);
			return JSP_FORM;
		}
	}

	/**
	 * 'UPDATE' action processing. <br>
	 * This action is based on the 'Post/Redirect/Get (PRG)' pattern, so it ends by 'http redirect'<br>
	 * @param administrator  entity to be updated
	 * @param bindingResult Spring MVC binding result
	 * @param model Spring MVC model
	 * @param redirectAttributes Spring MVC redirect attributes
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "/update" ) // GET or POST
	public String update(@Valid Administrator administrator, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes, HttpServletRequest httpServletRequest) {
		log("Action 'update'");
		try {
			if (!bindingResult.hasErrors()) {
				//--- Perform database operations
				Administrator administratorSaved = administratorService.update(administrator);
				model.addAttribute(MAIN_ENTITY_NAME, administratorSaved);
				//--- Set the result message
				messageHelper.addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
				log("Action 'update' : update done - redirect");
				return redirectToForm(httpServletRequest, administrator.getUid());
			} else {
				log("Action 'update' : binding errors");
				populateModel( model, administrator, FormMode.UPDATE);
				return JSP_FORM;
			}
		} catch(Exception e) {
			messageHelper.addException(model, "administrator.error.update", e);
			log("Action 'update' : Exception - " + e.getMessage() );
			populateModel( model, administrator, FormMode.UPDATE);
			return JSP_FORM;
		}
	}

	/**
	 * 'DELETE' action processing. <br>
	 * This action is based on the 'Post/Redirect/Get (PRG)' pattern, so it ends by 'http redirect'<br>
	 * @param redirectAttributes
	 * @param uid  primary key element
	 * @return
	 */
	@RequestMapping(value = "/delete/{uid}") // GET or POST
	public String delete(RedirectAttributes redirectAttributes, @PathVariable("uid") Long uid) {
		log("Action 'delete'" );
		try {
			administratorService.delete( uid );
			//--- Set the result message
			messageHelper.addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));	
		} catch(Exception e) {
			messageHelper.addException(redirectAttributes, "administrator.error.delete", e);
		}
		return redirectToList();
	}

}
