package com.bryan.db.dto;

import com.bryan.db.models.Order;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Component;

@Component
public class EntityDtoConvertOrderToOrderResponse {

    private final ModelMapper modelMapper;

    public EntityDtoConvertOrderToOrderResponse() {
        this.modelMapper = new ModelMapper();
    }

    public OrderResponse convertEntityDto(Order order) {

        TypeMap<Order, OrderResponse> typeMap = modelMapper.createTypeMap(Order.class, OrderResponse.class);

        return modelMapper.map(order, OrderResponse.class);

    }

}
