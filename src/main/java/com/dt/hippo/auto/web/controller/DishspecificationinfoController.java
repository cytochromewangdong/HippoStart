/*
 * Created on 12 五月 2015 ( Time 20:53:02 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.auto.web.controller;

import java.util.LinkedList;
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
import com.dt.hippo.auto.model.Dishspecificationinfo;
import com.dt.hippo.auto.model.Dishinfo;

//--- Services 
import com.dt.hippo.auto.business.service.DishspecificationinfoService;
import com.dt.hippo.auto.business.service.DishinfoService;

//--- List Items 
import com.dt.hippo.auto.web.listitem.DishinfoListItem;

/**
 * Spring MVC controller for 'Dishspecificationinfo' management.
 */
@Controller
@RequestMapping("/dishspecificationinfo")
public class DishspecificationinfoController extends AbstractController {

	//--- Variables names ( to be used in JSP with Expression Language )
	private static final String MAIN_ENTITY_NAME = "dishspecificationinfo";
	private static final String MAIN_LIST_NAME   = "list";

	//--- JSP pages names ( View name in the MVC model )
	private static final String JSP_FORM   = "dishspecificationinfo/form";
	private static final String JSP_LIST   = "dishspecificationinfo/list";

	//--- SAVE ACTION ( in the HTML form )
	private static final String SAVE_ACTION_CREATE   = "/dishspecificationinfo/create";
	private static final String SAVE_ACTION_UPDATE   = "/dishspecificationinfo/update";

	//--- Main entity service
	@Resource
    protected DishspecificationinfoService dishspecificationinfoService; // Injected by Spring
	//--- Other service(s)
	@Resource
    protected DishinfoService dishinfoService; // Injected by Spring

	//--------------------------------------------------------------------------------------
	/**
	 * Default constructor
	 */
	public DishspecificationinfoController() {
		super(DishspecificationinfoController.class, MAIN_ENTITY_NAME );
		log("DishspecificationinfoController created.");
	}

	//--------------------------------------------------------------------------------------
	// Spring MVC model management
	//--------------------------------------------------------------------------------------
	/**
	 * Populates the combo-box "items" for the referenced entity "Dishinfo"
	 * @param model
	 */
	private void populateListOfDishinfoItems(Model model) {
		List<Dishinfo> list = dishinfoService.findAll();
		List<DishinfoListItem> items = new LinkedList<DishinfoListItem>();
		for ( Dishinfo dishinfo : list ) {
			items.add(new DishinfoListItem( dishinfo ) );
		}
		model.addAttribute("listOfDishinfoItems", items ) ;
	}


	/**
	 * Populates the Spring MVC model with the given entity and eventually other useful data
	 * @param model
	 * @param dishspecificationinfo
	 */
	private void populateModel(Model model, Dishspecificationinfo dishspecificationinfo, FormMode formMode) {
		//--- Main entity
		model.addAttribute(MAIN_ENTITY_NAME, dishspecificationinfo);
		if ( formMode == FormMode.CREATE ) {
			model.addAttribute(MODE, MODE_CREATE); // The form is in "create" mode
			model.addAttribute(SAVE_ACTION, SAVE_ACTION_CREATE); 			
			//--- Other data useful in this screen in "create" mode (all fields)
			populateListOfDishinfoItems(model);
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
	 * Shows a list with all the occurrences of Dishspecificationinfo found in the database
	 * @param model Spring MVC model
	 * @return
	 */
	@RequestMapping()
	public String list(Model model) {
		log("Action 'list'");
		List<Dishspecificationinfo> list = dishspecificationinfoService.findAll();
		model.addAttribute(MAIN_LIST_NAME, list);		
		return JSP_LIST;
	}

	/**
	 * Shows a form page in order to create a new Dishspecificationinfo
	 * @param model Spring MVC model
	 * @return
	 */
	@RequestMapping("/form")
	public String formForCreate(Model model) {
		log("Action 'formForCreate'");
		//--- Populates the model with a new instance
		Dishspecificationinfo dishspecificationinfo = new Dishspecificationinfo();	
		populateModel( model, dishspecificationinfo, FormMode.CREATE);
		return JSP_FORM;
	}

	/**
	 * Shows a form page in order to update an existing Dishspecificationinfo
	 * @param model Spring MVC model
	 * @param dishid  primary key element
	 * @param uid  primary key element
	 * @return
	 */
	@RequestMapping(value = "/form/{dishid}/{uid}")
	public String formForUpdate(Model model, @PathVariable("dishid") Long dishid, @PathVariable("uid") Long uid ) {
		log("Action 'formForUpdate'");
		//--- Search the entity by its primary key and stores it in the model 
		Dishspecificationinfo dishspecificationinfo = dishspecificationinfoService.findById(dishid, uid);
		populateModel( model, dishspecificationinfo, FormMode.UPDATE);		
		return JSP_FORM;
	}

	/**
	 * 'CREATE' action processing. <br>
	 * This action is based on the 'Post/Redirect/Get (PRG)' pattern, so it ends by 'http redirect'<br>
	 * @param dishspecificationinfo  entity to be created
	 * @param bindingResult Spring MVC binding result
	 * @param model Spring MVC model
	 * @param redirectAttributes Spring MVC redirect attributes
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "/create" ) // GET or POST
	public String create(@Valid Dishspecificationinfo dishspecificationinfo, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes, HttpServletRequest httpServletRequest) {
		log("Action 'create'");
		try {
			if (!bindingResult.hasErrors()) {
				Dishspecificationinfo dishspecificationinfoCreated = dishspecificationinfoService.create(dishspecificationinfo); 
				model.addAttribute(MAIN_ENTITY_NAME, dishspecificationinfoCreated);

				//---
				messageHelper.addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
				return redirectToForm(httpServletRequest, dishspecificationinfo.getDishid(), dishspecificationinfo.getUid() );
			} else {
				populateModel( model, dishspecificationinfo, FormMode.CREATE);
				return JSP_FORM;
			}
		} catch(Exception e) {
			log("Action 'create' : Exception - " + e.getMessage() );
			messageHelper.addException(model, "dishspecificationinfo.error.create", e);
			populateModel( model, dishspecificationinfo, FormMode.CREATE);
			return JSP_FORM;
		}
	}

	/**
	 * 'UPDATE' action processing. <br>
	 * This action is based on the 'Post/Redirect/Get (PRG)' pattern, so it ends by 'http redirect'<br>
	 * @param dishspecificationinfo  entity to be updated
	 * @param bindingResult Spring MVC binding result
	 * @param model Spring MVC model
	 * @param redirectAttributes Spring MVC redirect attributes
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "/update" ) // GET or POST
	public String update(@Valid Dishspecificationinfo dishspecificationinfo, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes, HttpServletRequest httpServletRequest) {
		log("Action 'update'");
		try {
			if (!bindingResult.hasErrors()) {
				//--- Perform database operations
				Dishspecificationinfo dishspecificationinfoSaved = dishspecificationinfoService.update(dishspecificationinfo);
				model.addAttribute(MAIN_ENTITY_NAME, dishspecificationinfoSaved);
				//--- Set the result message
				messageHelper.addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
				log("Action 'update' : update done - redirect");
				return redirectToForm(httpServletRequest, dishspecificationinfo.getDishid(), dishspecificationinfo.getUid());
			} else {
				log("Action 'update' : binding errors");
				populateModel( model, dishspecificationinfo, FormMode.UPDATE);
				return JSP_FORM;
			}
		} catch(Exception e) {
			messageHelper.addException(model, "dishspecificationinfo.error.update", e);
			log("Action 'update' : Exception - " + e.getMessage() );
			populateModel( model, dishspecificationinfo, FormMode.UPDATE);
			return JSP_FORM;
		}
	}

	/**
	 * 'DELETE' action processing. <br>
	 * This action is based on the 'Post/Redirect/Get (PRG)' pattern, so it ends by 'http redirect'<br>
	 * @param redirectAttributes
	 * @param dishid  primary key element
	 * @param uid  primary key element
	 * @return
	 */
	@RequestMapping(value = "/delete/{dishid}/{uid}") // GET or POST
	public String delete(RedirectAttributes redirectAttributes, @PathVariable("dishid") Long dishid, @PathVariable("uid") Long uid) {
		log("Action 'delete'" );
		try {
			dishspecificationinfoService.delete( dishid, uid );
			//--- Set the result message
			messageHelper.addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));	
		} catch(Exception e) {
			messageHelper.addException(redirectAttributes, "dishspecificationinfo.error.delete", e);
		}
		return redirectToList();
	}

}
