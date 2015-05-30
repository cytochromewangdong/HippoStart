package com.dt.hippo.business.model.com;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.dt.hippo.auto.model.Orderheader;

public class OrderCom extends AbstractCom
{
	// @JsonView(Views.InternalOrder.class)
	// private String internal;
	//
	// @JsonView(Views.PublicOrder.class)
	// private String tPublic;
	//
	@NotNull
	private long storeId;

	public long getStoreId()
	{
		return storeId;
	}

	public void setStoreId(long storeId)
	{
		this.storeId = storeId;
	}
	
	@NotNull
	@NotBlank
	@Min(1)
	private Long totalCost;
	
	@NotNull
	@Min(0)
	@Max(10)
	private Integer paymentmethod;

	private String orderno;
	
	public String getOrderno()
	{
		return orderno;
	}

	public void setOrderno(String orderno)
	{
		this.orderno = orderno;
	}

	public Integer getPaymentmethod()
	{
		return paymentmethod;
	}

	public void setPaymentmethod(Integer paymentmethod)
	{
		this.paymentmethod = paymentmethod;
	}

	public Long getTotalCost()
	{
		return totalCost;
	}

	public void setTotalCost(Long totalCost)
	{
		this.totalCost = totalCost;
	}
	// @JsonView(Views.PublicOrder.class)
	@NotEmpty
	private List<OrderRowBean> listOfItemOrdered;
	
	private List<OrderRowBean> listOfItemPriceNotMatch;

	public List<OrderRowBean> getListOfItemPriceNotMatch()
	{
		return listOfItemPriceNotMatch;
	}

	public void setListOfItemPriceNotMatch(
			List<OrderRowBean> listOfItemPriceNotMatch)
	{
		this.listOfItemPriceNotMatch = listOfItemPriceNotMatch;
	}

	public List<OrderRowBean> getListOfItemOrdered()
	{
		return listOfItemOrdered;
	}

	public void setListOfItemOrdered(
			List<OrderRowBean> listOfItemOrdered)
	{
		this.listOfItemOrdered = listOfItemOrdered;
	}

	private List<Orderheader> listOfOrder;

	public List<Orderheader> getListOfOrder()
	{
		return listOfOrder;
	}

	public void setListOfOrder(List<Orderheader> listOfOrder)
	{
		this.listOfOrder = listOfOrder;
	}
}
