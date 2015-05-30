/*
 * Created on 18 五月 2015 ( Time 11:07:11 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package com.dt.hippo.auto.model;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.dt.hippo.auto.model.jpa.DishpriceEntity;
import com.dt.hippo.business.common.JSCompatibleIdGenerator;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.wordnik.swagger.annotations.ApiModelProperty;

@JsonIdentityInfo(generator = JSCompatibleIdGenerator.class)
public class Dishspecificationinfo extends
		com.dt.hippo.auto.model.base.Dishspecificationinfo
		implements Serializable
{

	private static final long serialVersionUID = 1L;
	// ----------------------------------------------------------------------
	// ENTITY LINKS ( RELATIONSHIP )
	// ----------------------------------------------------------------------
	protected Dishinfo dishinfo;
	protected List<Dishprice> listOfDishprice;
	protected List<Comboinfo> listOfComboinfo;
	
	protected List<Comboinfo> defaultComboSet;
	public List<Comboinfo> getDefaultComboSet()
	{
		return defaultComboSet;
	}

	public void setDefaultComboSet(List<Comboinfo> defaultComboSet)
	{
		this.defaultComboSet = defaultComboSet;
	}

	protected boolean isCombo;

	public boolean isCombo()
	{
		return isCombo;
	}

	public void setCombo(boolean isCombo)
	{
		this.isCombo = isCombo;
	}

	// protected List<Promotiondetailinfo> listOfPromotiondetailinfo;
	protected Promotioninfo promotioninfo;
	protected Promotiondetailinfo promotiondetailinfo;

	public Promotioninfo getPromotioninfo()
	{
		return promotioninfo;
	}

	public void setPromotioninfo(Promotioninfo promotioninfo)
	{
		this.promotioninfo = promotioninfo;
	}

	public Promotiondetailinfo getPromotiondetailinfo()
	{
		return promotiondetailinfo;
	}

	public void setPromotiondetailinfo(
			Promotiondetailinfo promotiondetailinfo)
	{
		this.promotiondetailinfo = promotiondetailinfo;
	}

	protected DishpriceEntity currentPrice;

	public DishpriceEntity getCurrentPrice()
	{
		return currentPrice;
	}

	public void setCurrentPrice(DishpriceEntity currentPrice)
	{
		this.currentPrice = currentPrice;
	}

	@NotNull
	protected Long realprice;

	public Long getRealprice()
	{
		return realprice;
	}

	public void setRealprice(Long realprice)
	{
		this.realprice = realprice;
	}

	// ----------------------------------------------------------------------
	// GETTERS & SETTERS FOR LINKS
	// ----------------------------------------------------------------------
	public void setDishinfo(Dishinfo dishinfo)
	{
		this.dishinfo = dishinfo;
	}

	public Dishinfo getDishinfo()
	{
		return this.dishinfo;
	}

	public void setListOfDishprice(
			List<Dishprice> listOfDishprice)
	{
		this.listOfDishprice = listOfDishprice;
	}

	public List<Dishprice> getListOfDishprice()
	{
		return this.listOfDishprice;
	}

	public void setListOfComboinfo(
			List<Comboinfo> listOfComboinfo)
	{
		this.listOfComboinfo = listOfComboinfo;
	}

	public List<Comboinfo> getListOfComboinfo()
	{
		return this.listOfComboinfo;
	}

	public Comboinfo fetchComboinfoWithSpecificationId(long specificationId)
	{
		for(Comboinfo each:listOfComboinfo)
		{
			if(each.getSpecificationid() == specificationId)
			{
				return each;
			}
		}
		return null;
	}
	@ApiModelProperty(value = "combo", notes = "the combo attached to the dish")
	protected Dishinfo attachedCombo;

	public Dishinfo getAttachedCombo()
	{
		return attachedCombo;
	}

	public void setAttachedCombo(Dishinfo attachedCombo)
	{
		this.attachedCombo = attachedCombo;
	}

	// public void setListOfPromotiondetailinfo( List<Promotiondetailinfo>
	// listOfPromotiondetailinfo ) {
	// this.listOfPromotiondetailinfo = listOfPromotiondetailinfo;
	// }
	// public List<Promotiondetailinfo> getListOfPromotiondetailinfo() {
	// return this.listOfPromotiondetailinfo;
	// }

}
