package com.bryan.db.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {

    private OrderResponse data;
    private int responseCode;
    private String message;

}
