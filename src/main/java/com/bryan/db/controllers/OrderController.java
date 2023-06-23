package com.bryan.db.controllers;

import com.bryan.db.dto.EntityDtoConvertOrderToOrderResponse;
import com.bryan.db.dto.OrderRequest;
import com.bryan.db.dto.OrderResponse;
import com.bryan.db.dto.Response;
import com.bryan.db.exception.NotFoundOrderException;
import com.bryan.db.exception.WrongTypeParameterException;
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

    @Autowired
    EntityDtoConvertOrderToOrderResponse entityDtoConvertOrderOrderResponse;

    @GetMapping("/{id}")
    public ResponseEntity<Response> getOrderById(@PathVariable String id) throws WrongTypeParameterException {

        long orderId;
        try {
            orderId = Long.parseLong(id);
        } catch (Exception e) {
            throw new WrongTypeParameterException("Tipo de dato incorrecto");
        }

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("uuid", "value");

        Optional<Order> order = orderService.getOrderById(orderId);

        if (order.isEmpty()) {
            throw new NotFoundOrderException("No existe el número de orden indicado");
        }

        OrderResponse orderResponse = entityDtoConvertOrderOrderResponse.convertEntityDto(order.get());

        Response response = new Response(orderResponse, 200, "Consulta exitosa");
        return new ResponseEntity<>(response, responseHeaders, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Order>> getAllOrder(@RequestParam(name = "quantity") String quantity,
                                                   @RequestParam(name = "skip") String skip) {

        int quantityValue;
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
            if (payload.getStatus() == null || payload.getId() <= 0) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


        Boolean response = orderService.updateStatus(payload);

        if (!response) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("statistics")
    public ResponseEntity<String> orderStatistics() {
        return ResponseEntity.ok().body("hola");
    }
}
