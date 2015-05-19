/*
 * Created on 18 五月 2015 ( Time 11:07:09 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.auto.web.listitem;

import com.dt.hippo.auto.model.Cateringcorpinfo;
import com.dt.hippo.auto.web.common.ListItem;

public class CateringcorpinfoListItem implements ListItem {

	private final String value ;
	private final String label ;
	
	public CateringcorpinfoListItem(Cateringcorpinfo cateringcorpinfo) {
		super();

		this.value = ""
			 + cateringcorpinfo.getUid()
		;

		//TODO : Define here the attributes to be displayed as the label
		this.label = cateringcorpinfo.toString();
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
