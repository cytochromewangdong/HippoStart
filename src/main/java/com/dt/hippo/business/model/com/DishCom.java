package com.dt.hippo.business.model.com;

import java.util.List;

import com.dt.hippo.auto.model.Orderheader;
import com.dt.hippo.core.base.BaseResult;

public class DishCom extends AbstractCom
{
//	private List<Category> categoryList;
//
//	public List<Category> getCategoryList()
//	{
//		return categoryList;
//	}
//
//	public void setCategoryList(List<Category> categoryList)
//	{
//		this.categoryList = categoryList;
//	}
    
    private StoreInfo storeInfo;
	
	private List<Orderheader> historyOrderList;

    public List<Orderheader> getHistoryOrderList()
    {
        return historyOrderList;
    }

    public void setHistoryOrderList(List<Orderheader> historyOrderList)
    {
        this.historyOrderList = historyOrderList;
    }

    public StoreInfo getStoreInfo()
    {
        return storeInfo;
    }

    public void setStoreInfo(StoreInfo storeInfo)
    {
        this.storeInfo = storeInfo;
    }   

}
