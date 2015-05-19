/*
 * Created on 18 五月 2015 ( Time 11:07:09 )
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
import com.dt.hippo.auto.model.Cateringcorpinfo;

//--- Services 
import com.dt.hippo.auto.business.service.CateringcorpinfoService;


/**
 * Spring MVC controller for 'Cateringcorpinfo' management.
 */
@Controller
@RequestMapping("/cateringcorpinfo")
public class CateringcorpinfoController extends AbstractController {

	//--- Variables names ( to be used in JSP with Expression Language )
	private static final String MAIN_ENTITY_NAME = "cateringcorpinfo";
	private static final String MAIN_LIST_NAME   = "list";

	//--- JSP pages names ( View name in the MVC model )
	private static final String JSP_FORM   = "cateringcorpinfo/form";
	private static final String JSP_LIST   = "cateringcorpinfo/list";

	//--- SAVE ACTION ( in the HTML form )
	private static final String SAVE_ACTION_CREATE   = "/cateringcorpinfo/create";
	private static final String SAVE_ACTION_UPDATE   = "/cateringcorpinfo/update";

	//--- Main entity service
	@Resource
    protected CateringcorpinfoService cateringcorpinfoService; // Injected by Spring
	//--- Other service(s)

	//--------------------------------------------------------------------------------------
	/**
	 * Default constructor
	 */
	public CateringcorpinfoController() {
		super(CateringcorpinfoController.class, MAIN_ENTITY_NAME );
		log("CateringcorpinfoController created.");
	}

	//--------------------------------------------------------------------------------------
	// Spring MVC model management
	//--------------------------------------------------------------------------------------

	/**
	 * Populates the Spring MVC model with the given entity and eventually other useful data
	 * @param model
	 * @param cateringcorpinfo
	 */
	private void populateModel(Model model, Cateringcorpinfo cateringcorpinfo, FormMode formMode) {
		//--- Main entity
		model.addAttribute(MAIN_ENTITY_NAME, cateringcorpinfo);
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
	 * Shows a list with all the occurrences of Cateringcorpinfo found in the database
	 * @param model Spring MVC model
	 * @return
	 */
	@RequestMapping()
	public String list(Model model) {
		log("Action 'list'");
		List<Cateringcorpinfo> list = cateringcorpinfoService.findAll();
		model.addAttribute(MAIN_LIST_NAME, list);		
		return JSP_LIST;
	}

	/**
	 * Shows a form page in order to create a new Cateringcorpinfo
	 * @param model Spring MVC model
	 * @return
	 */
	@RequestMapping("/form")
	public String formForCreate(Model model) {
		log("Action 'formForCreate'");
		//--- Populates the model with a new instance
		Cateringcorpinfo cateringcorpinfo = new Cateringcorpinfo();	
		populateModel( model, cateringcorpinfo, FormMode.CREATE);
		return JSP_FORM;
	}

	/**
	 * Shows a form page in order to update an existing Cateringcorpinfo
	 * @param model Spring MVC model
	 * @param uid  primary key element
	 * @return
	 */
	@RequestMapping(value = "/form/{uid}")
	public String formForUpdate(Model model, @PathVariable("uid") Long uid ) {
		log("Action 'formForUpdate'");
		//--- Search the entity by its primary key and stores it in the model 
		Cateringcorpinfo cateringcorpinfo = cateringcorpinfoService.findById(uid);
		populateModel( model, cateringcorpinfo, FormMode.UPDATE);		
		return JSP_FORM;
	}

	/**
	 * 'CREATE' action processing. <br>
	 * This action is based on the 'Post/Redirect/Get (PRG)' pattern, so it ends by 'http redirect'<br>
	 * @param cateringcorpinfo  entity to be created
	 * @param bindingResult Spring MVC binding result
	 * @param model Spring MVC model
	 * @param redirectAttributes Spring MVC redirect attributes
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "/create" ) // GET or POST
	public String create(@Valid Cateringcorpinfo cateringcorpinfo, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes, HttpServletRequest httpServletRequest) {
		log("Action 'create'");
		try {
			if (!bindingResult.hasErrors()) {
				Cateringcorpinfo cateringcorpinfoCreated = cateringcorpinfoService.create(cateringcorpinfo); 
				model.addAttribute(MAIN_ENTITY_NAME, cateringcorpinfoCreated);

				//---
				messageHelper.addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
				return redirectToForm(httpServletRequest, cateringcorpinfo.getUid() );
			} else {
				populateModel( model, cateringcorpinfo, FormMode.CREATE);
				return JSP_FORM;
			}
		} catch(Exception e) {
			log("Action 'create' : Exception - " + e.getMessage() );
			messageHelper.addException(model, "cateringcorpinfo.error.create", e);
			populateModel( model, cateringcorpinfo, FormMode.CREATE);
			return JSP_FORM;
		}
	}

	/**
	 * 'UPDATE' action processing. <br>
	 * This action is based on the 'Post/Redirect/Get (PRG)' pattern, so it ends by 'http redirect'<br>
	 * @param cateringcorpinfo  entity to be updated
	 * @param bindingResult Spring MVC binding result
	 * @param model Spring MVC model
	 * @param redirectAttributes Spring MVC redirect attributes
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "/update" ) // GET or POST
	public String update(@Valid Cateringcorpinfo cateringcorpinfo, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes, HttpServletRequest httpServletRequest) {
		log("Action 'update'");
		try {
			if (!bindingResult.hasErrors()) {
				//--- Perform database operations
				Cateringcorpinfo cateringcorpinfoSaved = cateringcorpinfoService.update(cateringcorpinfo);
				model.addAttribute(MAIN_ENTITY_NAME, cateringcorpinfoSaved);
				//--- Set the result message
				messageHelper.addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
				log("Action 'update' : update done - redirect");
				return redirectToForm(httpServletRequest, cateringcorpinfo.getUid());
			} else {
				log("Action 'update' : binding errors");
				populateModel( model, cateringcorpinfo, FormMode.UPDATE);
				return JSP_FORM;
			}
		} catch(Exception e) {
			messageHelper.addException(model, "cateringcorpinfo.error.update", e);
			log("Action 'update' : Exception - " + e.getMessage() );
			populateModel( model, cateringcorpinfo, FormMode.UPDATE);
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
			cateringcorpinfoService.delete( uid );
			//--- Set the result message
			messageHelper.addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));	
		} catch(Exception e) {
			messageHelper.addException(redirectAttributes, "cateringcorpinfo.error.delete", e);
		}
		return redirectToList();
	}

}
