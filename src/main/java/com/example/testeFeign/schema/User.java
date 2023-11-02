package com.example.testeFeign.schema;

import lombok.Data;

import java.util.UUID;

@Data
public class User {

    private UUID id;
    private String username;
}
