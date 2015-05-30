package com.dt.hippo.my.service;

import java.util.List;

import com.dt.hippo.auto.model.Orderheader;
import com.dt.hippo.business.model.com.OrderCom;


public interface CstOrderService
{
    public List<Orderheader> getPastOrders(Long userId, Long maxOrderId);

    public OrderCom generateNewOrder(OrderCom com, int payMethod);
    
    public List<Orderheader> getPastOrders(Long storeId, Long userId, Long maxOrderId);
    
    

}
