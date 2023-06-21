package com.bryan.db.services;

import com.bryan.db.models.Order;
import com.bryan.db.repository.OrderDaoI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements OrderServiceI {

    @Autowired
    private OrderDaoI orderDao;

    @Override
    public Optional<Order> getOrderById(Long id) {
        Optional<Order> order = orderDao.findById(id);
        return order;
    }

    @Override
    public List<Order> getAllOrder(int limit, int offset ) {
        return orderDao.findOrdersWithLimitAndOffset(limit, offset);
    }

    @Override
    public String addOrder() {
        return null;
    }

    @Override
    public String updateStatus() {
        return null;
    }

    @Override
    public String getStatistics() {
        return null;
    }
}
