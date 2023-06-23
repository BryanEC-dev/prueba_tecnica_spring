package com.bryan.db.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ExceptionResponse {
    private Timestamp timestamp;
    private String message;
    private int responseCode;
    private String status;

}
