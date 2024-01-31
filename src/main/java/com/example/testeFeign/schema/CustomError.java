package com.example.testeFeign.schema;

import lombok.Data;

@Data
public class CustomError {

    private Integer code;
    private String message;
}
