package com.bryan.db.services;

import com.bryan.db.dto.OrderRequest;
import com.bryan.db.models.Order;
import com.bryan.db.repository.OrderDaoI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class OrderService implements OrderServiceI {

    @Autowired
    private OrderDaoI orderDao;

    @Override
    public Optional<Order> getOrderById(Long id) throws NoSuchElementException, RuntimeException {
        Optional<Order> order = orderDao.findById(id);
        //Optional<Order> order = orderDao.findByIdWithOrderDetails(id);
        return order;
    }

    @Override
    public List<Order> getAllOrder(int limit, int offset) throws RuntimeException {
        return orderDao.findOrdersWithLimitAndOffset(limit, offset);
    }

    @Override
    public Boolean addOrder(OrderRequest orderRequest) throws RuntimeException {
        Order order = new Order();
        order.setDirection(orderRequest.getDirection());
        order.setStatus(orderRequest.getStatus());

        orderDao.save(order);


        return true;
    }

    @Override
    public Boolean updateStatus(OrderRequest orderRequest) throws RuntimeException {

        Optional<Order> existsOrder = orderDao.findById((long) orderRequest.getId());

        if (existsOrder.isEmpty()) {
            return false;
        }
        Order order = existsOrder.get();

        order.setStatus(orderRequest.getStatus());

        orderDao.save(order);
        return true;

    }

    @Override
    public String getStatistics() throws RuntimeException {
        return null;
    }
}
