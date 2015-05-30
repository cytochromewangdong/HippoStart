package com.dt.hippo.business.model.com;

import java.util.List;
import java.util.Map;

import com.dt.hippo.auto.model.Category;
import com.dt.hippo.auto.model.Dishinfo;
import com.dt.hippo.auto.model.Dishspecificationinfo;
import com.dt.hippo.auto.model.Vouchergeneratorinfo;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class StoreInfo
{

	public StoreInfo(long storeid)
	{
		this.storeid = storeid;
	}
	private long storeid;
	public long getStoreid()
	{
		return storeid;
	}

	public void setStoreid(long storeid)
	{
		this.storeid = storeid;
	}

	private long corpid;
	public long getCorpid()
	{
		return corpid;
	}

	public void setCorpid(long corpid)
	{
		this.corpid = corpid;
	}

	private List<Category> categoryList;

	public List<Category> getCategoryList()
	{
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList)
	{
		this.categoryList = categoryList;
	}
	
	@JsonIgnore
	private Map<Long, Dishspecificationinfo> bufferForAllDishes;

	public Map<Long, Dishspecificationinfo> getBufferForAllDishes()
	{
		return bufferForAllDishes;
	}

	public void setBufferForAllDishes(
			Map<Long, Dishspecificationinfo> bufferForAllDishes)
	{
		this.bufferForAllDishes = bufferForAllDishes;
	}
	
	private List<Vouchergeneratorinfo> voucherGeneratorList;
	
	public List<Vouchergeneratorinfo> getVoucherGeneratorList()
    {
        return voucherGeneratorList;
    }

    public void setVoucherGeneratorList(List<Vouchergeneratorinfo> voucherGeneratorList)
    {
        this.voucherGeneratorList = voucherGeneratorList;
    }
    
    public List<Dishinfo> getListOfAD()
    {
        return listOfAD;
    }

    public void setListOfAD(List<Dishinfo> listOfAD)
    {
        this.listOfAD = listOfAD;
    }
    private List<Dishinfo> listOfAD;
	
}
