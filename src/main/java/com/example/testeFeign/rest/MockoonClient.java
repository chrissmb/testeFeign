package com.example.testeFeign.rest;

import com.example.testeFeign.schema.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "mockoon", url = "${mockoon.url.base}")
public interface MockoonClient {

    @GetMapping("users")
    List<User> getUsers();

    @GetMapping("someError")
    String getSomeError();
}
