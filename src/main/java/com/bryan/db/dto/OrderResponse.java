package com.bryan.db.dto;

import com.bryan.db.models.Product;
import lombok.Data;

import java.util.List;

@Data
public class OrderResponse {

    private String status;
    private String direction;
    private List<Product> products;
}
