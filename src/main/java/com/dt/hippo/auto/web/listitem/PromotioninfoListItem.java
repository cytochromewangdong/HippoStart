/*
 * Created on 12 五月 2015 ( Time 20:53:06 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.auto.web.listitem;

import com.dt.hippo.auto.model.Promotioninfo;
import com.dt.hippo.auto.web.common.ListItem;

public class PromotioninfoListItem implements ListItem {

	private final String value ;
	private final String label ;
	
	public PromotioninfoListItem(Promotioninfo promotioninfo) {
		super();

		this.value = ""
			 + promotioninfo.getUid()
		;

		//TODO : Define here the attributes to be displayed as the label
		this.label = promotioninfo.toString();
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
