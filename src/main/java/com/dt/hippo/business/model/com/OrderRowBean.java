package com.dt.hippo.business.model.com;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.dt.hippo.business.model.jsonview.Views;
import com.fasterxml.jackson.annotation.JsonView;

public class OrderRowBean
{
	// @JsonView(Views.PublicOrder.class)
	@NotNull
	private Long dishVoucherUid;

	// @JsonView(Views.InternalOrder.class)
	@NotNull
	@Min(1)
	private Long priceOrValue;

	public Long getPriceOrValue()
	{
		return priceOrValue;
	}

	public void setPriceOrValue(Long priceOrValue)
	{
		this.priceOrValue = priceOrValue;
	}

	public Long getDishVoucherUid()
	{
		return dishVoucherUid;
	}

	public void setDishVoucherUid(Long dishVoucherUid)
	{
		this.dishVoucherUid = dishVoucherUid;
	}

	// @JsonView(Views.PublicOrder.class)
	@NotNull
	@Min(1)
	private Integer amount;
	// 0:一般菜点， 1：套餐
	@Max(1)
	@Min(0)
	private Integer dishType;

	public Integer getDishType()
	{
		return dishType;
	}

	public void setDishType(Integer dishType)
	{
		this.dishType = dishType;
	}

	// 0 菜品 1 赠券
	@NotNull
	@Max(1)
	@Min(0)
	private Integer type;

	public Integer getAmount()
	{
		return amount;
	}

	public void setAmount(Integer amount)
	{
		this.amount = amount;
	}

	public Integer getType()
	{
		return type;
	}

	public void setType(Integer type)
	{
		this.type = type;
	}

	private List<ComboItem> itemListOfCombo;

	public List<ComboItem> getItemListOfCombo()
	{
		return itemListOfCombo;
	}

	public void setItemListOfCombo(
			List<ComboItem> itemListOfCombo)
	{
		this.itemListOfCombo = itemListOfCombo;
	}
	
	
	private String name;
	
	private Long priceOnServer;

	
	private int failReason;
	public int getFailReason()
	{
		return failReason;
	}

	public void setFailReason(int failReason)
	{
		this.failReason = failReason;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Long getPriceOnServer()
	{
		return priceOnServer;
	}

	public void setPriceOnServer(Long priceOnServer)
	{
		this.priceOnServer = priceOnServer;
	}
	
	private Long standardPrice;

	public Long getStandardPrice()
	{
		return standardPrice;
	}

	public void setStandardPrice(Long standardPrice)
	{
		this.standardPrice = standardPrice;
	}

}
