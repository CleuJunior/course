package com.projectspring.course.resources;

import com.projectspring.course.entites.Order;
import com.projectspring.course.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    private final OrderService orderServiceService;

    @Autowired
    public OrderResource(OrderService orderServiceService) { this.orderServiceService = orderServiceService; }


    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        List<Order> listOfAllUsers = orderServiceService.findAllOrders();

        return ResponseEntity.ok()
                .body(listOfAllUsers);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findUserById(@PathVariable Long id) {
        Order orderObject = orderServiceService.findUserById(id);

        if(Objects.isNull(orderObject)) { return ResponseEntity.notFound().build(); }

        return ResponseEntity.ok()
                .body(orderObject);
    }
}
