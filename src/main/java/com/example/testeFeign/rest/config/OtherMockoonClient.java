package com.example.testeFeign.rest.config;

import com.example.testeFeign.schema.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "otherMockoon", url = "${mockoonUrlBase}", configuration = OtherRestConfig.class)
public interface OtherMockoonClient {

    @GetMapping("users")
    List<User> getUsers();

    @GetMapping("someError")
    String getSomeError();
}
