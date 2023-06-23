package com.bryan.db.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
public class OrderRequest {
    @Pattern(regexp = "^(pending|process|completed)$")
    @NotEmpty
    private String status;

    @NotEmpty(message = "La direction es obligatoria.")
    private String direction;

    private int id;
}
