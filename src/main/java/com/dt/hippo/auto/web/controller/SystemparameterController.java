/*
 * Created on 13 五月 2015 ( Time 21:15:32 )
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
import com.dt.hippo.auto.model.Systemparameter;

//--- Services 
import com.dt.hippo.auto.business.service.SystemparameterService;


/**
 * Spring MVC controller for 'Systemparameter' management.
 */
@Controller
@RequestMapping("/systemparameter")
public class SystemparameterController extends AbstractController {

	//--- Variables names ( to be used in JSP with Expression Language )
	private static final String MAIN_ENTITY_NAME = "systemparameter";
	private static final String MAIN_LIST_NAME   = "list";

	//--- JSP pages names ( View name in the MVC model )
	private static final String JSP_FORM   = "systemparameter/form";
	private static final String JSP_LIST   = "systemparameter/list";

	//--- SAVE ACTION ( in the HTML form )
	private static final String SAVE_ACTION_CREATE   = "/systemparameter/create";
	private static final String SAVE_ACTION_UPDATE   = "/systemparameter/update";

	//--- Main entity service
	@Resource
    protected SystemparameterService systemparameterService; // Injected by Spring
	//--- Other service(s)

	//--------------------------------------------------------------------------------------
	/**
	 * Default constructor
	 */
	public SystemparameterController() {
		super(SystemparameterController.class, MAIN_ENTITY_NAME );
		log("SystemparameterController created.");
	}

	//--------------------------------------------------------------------------------------
	// Spring MVC model management
	//--------------------------------------------------------------------------------------

	/**
	 * Populates the Spring MVC model with the given entity and eventually other useful data
	 * @param model
	 * @param systemparameter
	 */
	private void populateModel(Model model, Systemparameter systemparameter, FormMode formMode) {
		//--- Main entity
		model.addAttribute(MAIN_ENTITY_NAME, systemparameter);
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
	 * Shows a list with all the occurrences of Systemparameter found in the database
	 * @param model Spring MVC model
	 * @return
	 */
	@RequestMapping()
	public String list(Model model) {
		log("Action 'list'");
		List<Systemparameter> list = systemparameterService.findAll();
		model.addAttribute(MAIN_LIST_NAME, list);		
		return JSP_LIST;
	}

	/**
	 * Shows a form page in order to create a new Systemparameter
	 * @param model Spring MVC model
	 * @return
	 */
	@RequestMapping("/form")
	public String formForCreate(Model model) {
		log("Action 'formForCreate'");
		//--- Populates the model with a new instance
		Systemparameter systemparameter = new Systemparameter();	
		populateModel( model, systemparameter, FormMode.CREATE);
		return JSP_FORM;
	}

	/**
	 * Shows a form page in order to update an existing Systemparameter
	 * @param model Spring MVC model
	 * @param uid  primary key element
	 * @return
	 */
	@RequestMapping(value = "/form/{uid}")
	public String formForUpdate(Model model, @PathVariable("uid") Integer uid ) {
		log("Action 'formForUpdate'");
		//--- Search the entity by its primary key and stores it in the model 
		Systemparameter systemparameter = systemparameterService.findById(uid);
		populateModel( model, systemparameter, FormMode.UPDATE);		
		return JSP_FORM;
	}

	/**
	 * 'CREATE' action processing. <br>
	 * This action is based on the 'Post/Redirect/Get (PRG)' pattern, so it ends by 'http redirect'<br>
	 * @param systemparameter  entity to be created
	 * @param bindingResult Spring MVC binding result
	 * @param model Spring MVC model
	 * @param redirectAttributes Spring MVC redirect attributes
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "/create" ) // GET or POST
	public String create(@Valid Systemparameter systemparameter, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes, HttpServletRequest httpServletRequest) {
		log("Action 'create'");
		try {
			if (!bindingResult.hasErrors()) {
				Systemparameter systemparameterCreated = systemparameterService.create(systemparameter); 
				model.addAttribute(MAIN_ENTITY_NAME, systemparameterCreated);

				//---
				messageHelper.addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
				return redirectToForm(httpServletRequest, systemparameter.getUid() );
			} else {
				populateModel( model, systemparameter, FormMode.CREATE);
				return JSP_FORM;
			}
		} catch(Exception e) {
			log("Action 'create' : Exception - " + e.getMessage() );
			messageHelper.addException(model, "systemparameter.error.create", e);
			populateModel( model, systemparameter, FormMode.CREATE);
			return JSP_FORM;
		}
	}

	/**
	 * 'UPDATE' action processing. <br>
	 * This action is based on the 'Post/Redirect/Get (PRG)' pattern, so it ends by 'http redirect'<br>
	 * @param systemparameter  entity to be updated
	 * @param bindingResult Spring MVC binding result
	 * @param model Spring MVC model
	 * @param redirectAttributes Spring MVC redirect attributes
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "/update" ) // GET or POST
	public String update(@Valid Systemparameter systemparameter, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes, HttpServletRequest httpServletRequest) {
		log("Action 'update'");
		try {
			if (!bindingResult.hasErrors()) {
				//--- Perform database operations
				Systemparameter systemparameterSaved = systemparameterService.update(systemparameter);
				model.addAttribute(MAIN_ENTITY_NAME, systemparameterSaved);
				//--- Set the result message
				messageHelper.addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
				log("Action 'update' : update done - redirect");
				return redirectToForm(httpServletRequest, systemparameter.getUid());
			} else {
				log("Action 'update' : binding errors");
				populateModel( model, systemparameter, FormMode.UPDATE);
				return JSP_FORM;
			}
		} catch(Exception e) {
			messageHelper.addException(model, "systemparameter.error.update", e);
			log("Action 'update' : Exception - " + e.getMessage() );
			populateModel( model, systemparameter, FormMode.UPDATE);
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
	public String delete(RedirectAttributes redirectAttributes, @PathVariable("uid") Integer uid) {
		log("Action 'delete'" );
		try {
			systemparameterService.delete( uid );
			//--- Set the result message
			messageHelper.addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));	
		} catch(Exception e) {
			messageHelper.addException(redirectAttributes, "systemparameter.error.delete", e);
		}
		return redirectToList();
	}

}
