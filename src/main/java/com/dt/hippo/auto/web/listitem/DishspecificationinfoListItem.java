/*
 * Created on 18 五月 2015 ( Time 11:07:11 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.auto.web.listitem;

import com.dt.hippo.auto.model.Dishspecificationinfo;
import com.dt.hippo.auto.web.common.ListItem;

public class DishspecificationinfoListItem implements ListItem {

	private final String value ;
	private final String label ;
	
	public DishspecificationinfoListItem(Dishspecificationinfo dishspecificationinfo) {
		super();

		this.value = ""
			 + dishspecificationinfo.getUid()
		;

		//TODO : Define here the attributes to be displayed as the label
		this.label = dishspecificationinfo.toString();
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
