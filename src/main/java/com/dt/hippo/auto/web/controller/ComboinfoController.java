/*
 * Created on 14 五月 2015 ( Time 21:41:18 )
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
import com.dt.hippo.auto.model.Comboinfo;
import com.dt.hippo.auto.model.Dishinfo;
import com.dt.hippo.auto.model.Dishspecificationinfo;

//--- Services 
import com.dt.hippo.auto.business.service.ComboinfoService;
import com.dt.hippo.auto.business.service.DishinfoService;
import com.dt.hippo.auto.business.service.DishspecificationinfoService;

//--- List Items 
import com.dt.hippo.auto.web.listitem.DishinfoListItem;
import com.dt.hippo.auto.web.listitem.DishspecificationinfoListItem;

/**
 * Spring MVC controller for 'Comboinfo' management.
 */
@Controller
@RequestMapping("/comboinfo")
public class ComboinfoController extends AbstractController {

	//--- Variables names ( to be used in JSP with Expression Language )
	private static final String MAIN_ENTITY_NAME = "comboinfo";
	private static final String MAIN_LIST_NAME   = "list";

	//--- JSP pages names ( View name in the MVC model )
	private static final String JSP_FORM   = "comboinfo/form";
	private static final String JSP_LIST   = "comboinfo/list";

	//--- SAVE ACTION ( in the HTML form )
	private static final String SAVE_ACTION_CREATE   = "/comboinfo/create";
	private static final String SAVE_ACTION_UPDATE   = "/comboinfo/update";

	//--- Main entity service
	@Resource
    protected ComboinfoService comboinfoService; // Injected by Spring
	//--- Other service(s)
	@Resource
    protected DishinfoService dishinfoService; // Injected by Spring
	@Resource
    protected DishspecificationinfoService dishspecificationinfoService; // Injected by Spring

	//--------------------------------------------------------------------------------------
	/**
	 * Default constructor
	 */
	public ComboinfoController() {
		super(ComboinfoController.class, MAIN_ENTITY_NAME );
		log("ComboinfoController created.");
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
	 * Populates the combo-box "items" for the referenced entity "Dishspecificationinfo"
	 * @param model
	 */
	private void populateListOfDishspecificationinfoItems(Model model) {
		List<Dishspecificationinfo> list = dishspecificationinfoService.findAll();
		List<DishspecificationinfoListItem> items = new LinkedList<DishspecificationinfoListItem>();
		for ( Dishspecificationinfo dishspecificationinfo : list ) {
			items.add(new DishspecificationinfoListItem( dishspecificationinfo ) );
		}
		model.addAttribute("listOfDishspecificationinfoItems", items ) ;
	}


	/**
	 * Populates the Spring MVC model with the given entity and eventually other useful data
	 * @param model
	 * @param comboinfo
	 */
	private void populateModel(Model model, Comboinfo comboinfo, FormMode formMode) {
		//--- Main entity
		model.addAttribute(MAIN_ENTITY_NAME, comboinfo);
		if ( formMode == FormMode.CREATE ) {
			model.addAttribute(MODE, MODE_CREATE); // The form is in "create" mode
			model.addAttribute(SAVE_ACTION, SAVE_ACTION_CREATE); 			
			//--- Other data useful in this screen in "create" mode (all fields)
			populateListOfDishinfoItems(model);
			populateListOfDishspecificationinfoItems(model);
		}
		else if ( formMode == FormMode.UPDATE ) {
			model.addAttribute(MODE, MODE_UPDATE); // The form is in "update" mode
			model.addAttribute(SAVE_ACTION, SAVE_ACTION_UPDATE); 			
			//--- Other data useful in this screen in "update" mode (only non-pk fields)
			populateListOfDishinfoItems(model);
			populateListOfDishspecificationinfoItems(model);
		}
	}

	//--------------------------------------------------------------------------------------
	// Request mapping
	//--------------------------------------------------------------------------------------
	/**
	 * Shows a list with all the occurrences of Comboinfo found in the database
	 * @param model Spring MVC model
	 * @return
	 */
	@RequestMapping()
	public String list(Model model) {
		log("Action 'list'");
		List<Comboinfo> list = comboinfoService.findAll();
		model.addAttribute(MAIN_LIST_NAME, list);		
		return JSP_LIST;
	}

	/**
	 * Shows a form page in order to create a new Comboinfo
	 * @param model Spring MVC model
	 * @return
	 */
	@RequestMapping("/form")
	public String formForCreate(Model model) {
		log("Action 'formForCreate'");
		//--- Populates the model with a new instance
		Comboinfo comboinfo = new Comboinfo();	
		populateModel( model, comboinfo, FormMode.CREATE);
		return JSP_FORM;
	}

	/**
	 * Shows a form page in order to update an existing Comboinfo
	 * @param model Spring MVC model
	 * @param id  primary key element
	 * @return
	 */
	@RequestMapping(value = "/form/{id}")
	public String formForUpdate(Model model, @PathVariable("id") Long id ) {
		log("Action 'formForUpdate'");
		//--- Search the entity by its primary key and stores it in the model 
		Comboinfo comboinfo = comboinfoService.findById(id);
		populateModel( model, comboinfo, FormMode.UPDATE);		
		return JSP_FORM;
	}

	/**
	 * 'CREATE' action processing. <br>
	 * This action is based on the 'Post/Redirect/Get (PRG)' pattern, so it ends by 'http redirect'<br>
	 * @param comboinfo  entity to be created
	 * @param bindingResult Spring MVC binding result
	 * @param model Spring MVC model
	 * @param redirectAttributes Spring MVC redirect attributes
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "/create" ) // GET or POST
	public String create(@Valid Comboinfo comboinfo, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes, HttpServletRequest httpServletRequest) {
		log("Action 'create'");
		try {
			if (!bindingResult.hasErrors()) {
				Comboinfo comboinfoCreated = comboinfoService.create(comboinfo); 
				model.addAttribute(MAIN_ENTITY_NAME, comboinfoCreated);

				//---
				messageHelper.addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
				return redirectToForm(httpServletRequest, comboinfo.getId() );
			} else {
				populateModel( model, comboinfo, FormMode.CREATE);
				return JSP_FORM;
			}
		} catch(Exception e) {
			log("Action 'create' : Exception - " + e.getMessage() );
			messageHelper.addException(model, "comboinfo.error.create", e);
			populateModel( model, comboinfo, FormMode.CREATE);
			return JSP_FORM;
		}
	}

	/**
	 * 'UPDATE' action processing. <br>
	 * This action is based on the 'Post/Redirect/Get (PRG)' pattern, so it ends by 'http redirect'<br>
	 * @param comboinfo  entity to be updated
	 * @param bindingResult Spring MVC binding result
	 * @param model Spring MVC model
	 * @param redirectAttributes Spring MVC redirect attributes
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "/update" ) // GET or POST
	public String update(@Valid Comboinfo comboinfo, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes, HttpServletRequest httpServletRequest) {
		log("Action 'update'");
		try {
			if (!bindingResult.hasErrors()) {
				//--- Perform database operations
				Comboinfo comboinfoSaved = comboinfoService.update(comboinfo);
				model.addAttribute(MAIN_ENTITY_NAME, comboinfoSaved);
				//--- Set the result message
				messageHelper.addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
				log("Action 'update' : update done - redirect");
				return redirectToForm(httpServletRequest, comboinfo.getId());
			} else {
				log("Action 'update' : binding errors");
				populateModel( model, comboinfo, FormMode.UPDATE);
				return JSP_FORM;
			}
		} catch(Exception e) {
			messageHelper.addException(model, "comboinfo.error.update", e);
			log("Action 'update' : Exception - " + e.getMessage() );
			populateModel( model, comboinfo, FormMode.UPDATE);
			return JSP_FORM;
		}
	}

	/**
	 * 'DELETE' action processing. <br>
	 * This action is based on the 'Post/Redirect/Get (PRG)' pattern, so it ends by 'http redirect'<br>
	 * @param redirectAttributes
	 * @param id  primary key element
	 * @return
	 */
	@RequestMapping(value = "/delete/{id}") // GET or POST
	public String delete(RedirectAttributes redirectAttributes, @PathVariable("id") Long id) {
		log("Action 'delete'" );
		try {
			comboinfoService.delete( id );
			//--- Set the result message
			messageHelper.addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));	
		} catch(Exception e) {
			messageHelper.addException(redirectAttributes, "comboinfo.error.delete", e);
		}
		return redirectToList();
	}

}
