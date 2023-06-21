package com.bryan.db.controllers;

import com.bryan.db.dto.OrderRequest;
import com.bryan.db.dto.OrderResponse;
import com.bryan.db.models.Order;
import com.bryan.db.services.OrderServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@Validated
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

    @PostMapping("/")
    public ResponseEntity<String> addOrder(@Valid @RequestBody OrderRequest payload) {

        orderService.addOrder(payload);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/status")
    public ResponseEntity<String> changeStatus(@RequestBody OrderRequest payload) {

        try {
            if(payload.getStatus() == null || payload.getId() <= 0){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


        Boolean response  = orderService.updateStatus(payload);

        if(! response){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR)   ;
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("statistics")
    public ResponseEntity<String> orderStatistics() {
        return ResponseEntity.ok().body("hola");
    }
}
