/*
 * Created on 27 五月 2015 ( Time 17:55:56 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.auto.web.listitem;

import com.dt.hippo.auto.model.Vouchergeneratorinfo;
import com.dt.hippo.auto.web.common.ListItem;

public class VouchergeneratorinfoListItem implements ListItem {

	private final String value ;
	private final String label ;
	
	public VouchergeneratorinfoListItem(Vouchergeneratorinfo vouchergeneratorinfo) {
		super();

		this.value = ""
			 + vouchergeneratorinfo.getUid()
		;

		//TODO : Define here the attributes to be displayed as the label
		this.label = vouchergeneratorinfo.toString();
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
