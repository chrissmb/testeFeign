package com.example.testeFeign.rest;

import com.example.testeFeign.rest.config.OtherRestConfig;
import com.example.testeFeign.schema.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "otherMockoon", url = "${mockoon.url.base}", configuration = OtherRestConfig.class)
public interface OtherMockoonClient {

    @GetMapping("users")
    List<User> getUsers();

    @GetMapping("someError")
    String getSomeError();
}
