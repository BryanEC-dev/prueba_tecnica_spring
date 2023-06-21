package com.bryan.db.controllers;

import com.bryan.db.models.Order;
import com.bryan.db.services.OrderServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderServiceI orderService;

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable String id) {

        Long orderId;
        try {
            orderId = Long.parseLong(id);
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().build();
        }

        HttpHeaders responseHeaders = new HttpHeaders();

        responseHeaders.set("uuid", "value");
        Optional<Order> order = orderService.getOrderById(orderId);

        if (order.isEmpty()){
            return  ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().headers(responseHeaders).body(order.get());
    }

    @GetMapping("/")
    public ResponseEntity<List<Order>> getAllOrder(@RequestParam(name = "quantity") String quantity,
                                            @RequestParam(name = "skip") String skip) {

        int quantityValue ;
        int skipValue;
        try {
            quantityValue = Integer.parseInt(quantity);
            skipValue = Integer.parseInt(skip);
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().build();
        }

        List<Order> orders = orderService.getAllOrder(quantityValue, skipValue);
        return ResponseEntity.ok().body(orders);
    }

    @PostMapping("add/order")
    public ResponseEntity<String> addOrder() {

        return ResponseEntity.ok().body("hola");
    }

    @PostMapping("update/status")
    public ResponseEntity<String> changeStatus() {
        return ResponseEntity.ok().body("hola");
    }

    @PostMapping("statistics")
    public ResponseEntity<String> orderStatistics() {
        return ResponseEntity.ok().body("hola");
    }
}
