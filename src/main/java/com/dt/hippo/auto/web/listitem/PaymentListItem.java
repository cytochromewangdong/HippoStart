/*
 * Created on 13 五月 2015 ( Time 21:15:28 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.auto.web.listitem;

import com.dt.hippo.auto.model.Payment;
import com.dt.hippo.auto.web.common.ListItem;

public class PaymentListItem implements ListItem {

	private final String value ;
	private final String label ;
	
	public PaymentListItem(Payment payment) {
		super();

		this.value = ""
			 + payment.getUid()
		;

		//TODO : Define here the attributes to be displayed as the label
		this.label = payment.toString();
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
