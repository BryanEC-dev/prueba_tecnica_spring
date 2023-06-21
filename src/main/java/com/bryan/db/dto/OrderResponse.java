package com.bryan.db.dto;

import com.bryan.db.models.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {

    private Order data;
    private int responseCode;

}
