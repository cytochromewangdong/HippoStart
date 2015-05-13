/*
 * Created on 13 五月 2015 ( Time 21:15:30 )
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
import com.dt.hippo.auto.model.Scoreinfo;

//--- Services 
import com.dt.hippo.auto.business.service.ScoreinfoService;


/**
 * Spring MVC controller for 'Scoreinfo' management.
 */
@Controller
@RequestMapping("/scoreinfo")
public class ScoreinfoController extends AbstractController {

	//--- Variables names ( to be used in JSP with Expression Language )
	private static final String MAIN_ENTITY_NAME = "scoreinfo";
	private static final String MAIN_LIST_NAME   = "list";

	//--- JSP pages names ( View name in the MVC model )
	private static final String JSP_FORM   = "scoreinfo/form";
	private static final String JSP_LIST   = "scoreinfo/list";

	//--- SAVE ACTION ( in the HTML form )
	private static final String SAVE_ACTION_CREATE   = "/scoreinfo/create";
	private static final String SAVE_ACTION_UPDATE   = "/scoreinfo/update";

	//--- Main entity service
	@Resource
    protected ScoreinfoService scoreinfoService; // Injected by Spring
	//--- Other service(s)

	//--------------------------------------------------------------------------------------
	/**
	 * Default constructor
	 */
	public ScoreinfoController() {
		super(ScoreinfoController.class, MAIN_ENTITY_NAME );
		log("ScoreinfoController created.");
	}

	//--------------------------------------------------------------------------------------
	// Spring MVC model management
	//--------------------------------------------------------------------------------------

	/**
	 * Populates the Spring MVC model with the given entity and eventually other useful data
	 * @param model
	 * @param scoreinfo
	 */
	private void populateModel(Model model, Scoreinfo scoreinfo, FormMode formMode) {
		//--- Main entity
		model.addAttribute(MAIN_ENTITY_NAME, scoreinfo);
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
	 * Shows a list with all the occurrences of Scoreinfo found in the database
	 * @param model Spring MVC model
	 * @return
	 */
	@RequestMapping()
	public String list(Model model) {
		log("Action 'list'");
		List<Scoreinfo> list = scoreinfoService.findAll();
		model.addAttribute(MAIN_LIST_NAME, list);		
		return JSP_LIST;
	}

	/**
	 * Shows a form page in order to create a new Scoreinfo
	 * @param model Spring MVC model
	 * @return
	 */
	@RequestMapping("/form")
	public String formForCreate(Model model) {
		log("Action 'formForCreate'");
		//--- Populates the model with a new instance
		Scoreinfo scoreinfo = new Scoreinfo();	
		populateModel( model, scoreinfo, FormMode.CREATE);
		return JSP_FORM;
	}

	/**
	 * Shows a form page in order to update an existing Scoreinfo
	 * @param model Spring MVC model
	 * @param uid  primary key element
	 * @return
	 */
	@RequestMapping(value = "/form/{uid}")
	public String formForUpdate(Model model, @PathVariable("uid") Long uid ) {
		log("Action 'formForUpdate'");
		//--- Search the entity by its primary key and stores it in the model 
		Scoreinfo scoreinfo = scoreinfoService.findById(uid);
		populateModel( model, scoreinfo, FormMode.UPDATE);		
		return JSP_FORM;
	}

	/**
	 * 'CREATE' action processing. <br>
	 * This action is based on the 'Post/Redirect/Get (PRG)' pattern, so it ends by 'http redirect'<br>
	 * @param scoreinfo  entity to be created
	 * @param bindingResult Spring MVC binding result
	 * @param model Spring MVC model
	 * @param redirectAttributes Spring MVC redirect attributes
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "/create" ) // GET or POST
	public String create(@Valid Scoreinfo scoreinfo, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes, HttpServletRequest httpServletRequest) {
		log("Action 'create'");
		try {
			if (!bindingResult.hasErrors()) {
				Scoreinfo scoreinfoCreated = scoreinfoService.create(scoreinfo); 
				model.addAttribute(MAIN_ENTITY_NAME, scoreinfoCreated);

				//---
				messageHelper.addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
				return redirectToForm(httpServletRequest, scoreinfo.getUid() );
			} else {
				populateModel( model, scoreinfo, FormMode.CREATE);
				return JSP_FORM;
			}
		} catch(Exception e) {
			log("Action 'create' : Exception - " + e.getMessage() );
			messageHelper.addException(model, "scoreinfo.error.create", e);
			populateModel( model, scoreinfo, FormMode.CREATE);
			return JSP_FORM;
		}
	}

	/**
	 * 'UPDATE' action processing. <br>
	 * This action is based on the 'Post/Redirect/Get (PRG)' pattern, so it ends by 'http redirect'<br>
	 * @param scoreinfo  entity to be updated
	 * @param bindingResult Spring MVC binding result
	 * @param model Spring MVC model
	 * @param redirectAttributes Spring MVC redirect attributes
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "/update" ) // GET or POST
	public String update(@Valid Scoreinfo scoreinfo, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes, HttpServletRequest httpServletRequest) {
		log("Action 'update'");
		try {
			if (!bindingResult.hasErrors()) {
				//--- Perform database operations
				Scoreinfo scoreinfoSaved = scoreinfoService.update(scoreinfo);
				model.addAttribute(MAIN_ENTITY_NAME, scoreinfoSaved);
				//--- Set the result message
				messageHelper.addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
				log("Action 'update' : update done - redirect");
				return redirectToForm(httpServletRequest, scoreinfo.getUid());
			} else {
				log("Action 'update' : binding errors");
				populateModel( model, scoreinfo, FormMode.UPDATE);
				return JSP_FORM;
			}
		} catch(Exception e) {
			messageHelper.addException(model, "scoreinfo.error.update", e);
			log("Action 'update' : Exception - " + e.getMessage() );
			populateModel( model, scoreinfo, FormMode.UPDATE);
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
			scoreinfoService.delete( uid );
			//--- Set the result message
			messageHelper.addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));	
		} catch(Exception e) {
			messageHelper.addException(redirectAttributes, "scoreinfo.error.delete", e);
		}
		return redirectToList();
	}

}