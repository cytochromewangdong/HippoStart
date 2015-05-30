package com.dt.hippo.my.service;

import com.dt.hippo.business.model.com.DishCom;
import com.dt.hippo.business.model.com.StoreInfo;

public interface CstBusinessService
{
	public StoreInfo getStoreInfo(
			Long storeid);
	
	public DishCom getStoreinfoForUser(Long storeid,Long userid);
	
	public DishCom getStoreinfoForUser(Long storeid);
	
}
