/*
 * Created on 20 五月 2015 ( Time 20:24:22 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.auto.web.listitem;

import com.dt.hippo.auto.model.Category;
import com.dt.hippo.auto.web.common.ListItem;

public class CategoryListItem implements ListItem {

	private final String value ;
	private final String label ;
	
	public CategoryListItem(Category category) {
		super();

		this.value = ""
			 + category.getUid()
		;

		//TODO : Define here the attributes to be displayed as the label
		this.label = category.toString();
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
