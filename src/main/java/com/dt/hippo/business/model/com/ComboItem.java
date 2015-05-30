package com.dt.hippo.business.model.com;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ComboItem
{

	@NotNull
	@Min(1)
	private Long price;
	
	
	@NotNull
	private Long dishSpecificationUid;
	
	
	@NotNull
	@Min(1)
	private Integer amount;


	public Long getPrice()
	{
		return price;
	}


	public void setPrice(Long price)
	{
		this.price = price;
	}


	public Long getDishSpecificationUid()
	{
		return dishSpecificationUid;
	}


	public void setDishSpecificationUid(Long dishSpecificationUid)
	{
		this.dishSpecificationUid = dishSpecificationUid;
	}


	public Integer getAmount()
	{
		return amount;
	}


	public void setAmount(Integer amount)
	{
		this.amount = amount;
	}
}
