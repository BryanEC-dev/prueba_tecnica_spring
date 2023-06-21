package com.bryan.db.services;

import com.bryan.db.dto.OrderRequest;
import com.bryan.db.models.Order;

import java.util.List;
import java.util.Optional;


public interface OrderServiceI {
     Optional<Order> getOrderById(Long id);

    List<Order> getAllOrder(int limit, int offset);

     Boolean addOrder(OrderRequest order);

    Boolean updateStatus(OrderRequest order);

    public String getStatistics();
}
