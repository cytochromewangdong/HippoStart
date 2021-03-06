/*
 * Created on 18 五月 2015 ( Time 11:07:12 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.auto.web.listitem;

import com.dt.hippo.auto.model.Externalaccount;
import com.dt.hippo.auto.web.common.ListItem;

public class ExternalaccountListItem implements ListItem {

	private final String value ;
	private final String label ;
	
	public ExternalaccountListItem(Externalaccount externalaccount) {
		super();

		this.value = ""
			 + externalaccount.getUserid()
			 + "|"  + externalaccount.getUsersource()
		;

		//TODO : Define here the attributes to be displayed as the label
		this.label = externalaccount.toString();
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
