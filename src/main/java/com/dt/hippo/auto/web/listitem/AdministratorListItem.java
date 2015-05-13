/*
 * Created on 13 五月 2015 ( Time 21:15:22 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.auto.web.listitem;

import com.dt.hippo.auto.model.Administrator;
import com.dt.hippo.auto.web.common.ListItem;

public class AdministratorListItem implements ListItem {

	private final String value ;
	private final String label ;
	
	public AdministratorListItem(Administrator administrator) {
		super();

		this.value = ""
			 + administrator.getUid()
		;

		//TODO : Define here the attributes to be displayed as the label
		this.label = administrator.toString();
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public String getLabel() {
		return label;
	}

}