/*
 * Created on 30 五月 2015 ( Time 18:22:34 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.auto.web.listitem;

import com.dt.hippo.auto.model.Adlist;
import com.dt.hippo.auto.web.common.ListItem;

public class AdlistListItem implements ListItem {

	private final String value ;
	private final String label ;
	
	public AdlistListItem(Adlist adlist) {
		super();

		this.value = ""
			 + adlist.getUid()
		;

		//TODO : Define here the attributes to be displayed as the label
		this.label = adlist.toString();
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