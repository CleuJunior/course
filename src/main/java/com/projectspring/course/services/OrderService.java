package com.projectspring.course.services;

import com.projectspring.course.entites.Order;
import com.projectspring.course.repositories.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final IOrderRepository orderRepository;

    @Autowired
    public OrderService(IOrderRepository orderRepository) { this.orderRepository = orderRepository; }

    public List<Order> findAllOrders() { return orderRepository.findAll(); }

    public Order findUserById(Long id) {
        Optional<Order> userObject = orderRepository.findById(id);

        return userObject.orElse(null);
    }

}
