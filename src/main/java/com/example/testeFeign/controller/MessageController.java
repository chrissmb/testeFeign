package com.example.testeFeign.controller;

import com.example.testeFeign.rest.BadsslClient;
import com.example.testeFeign.rest.MockoonClient;
import com.example.testeFeign.rest.OtherMockoonClient;
import com.example.testeFeign.schema.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageController {

    @Autowired
    private MockoonClient client;

    @Autowired
    private OtherMockoonClient otherClient;

    @Autowired
    private BadsslClient badsslClient;

    @GetMapping("users")
    private List<User> getUsers(){
        return client.getUsers();
    }

    @GetMapping("someError")
    private String getSomeError(){
        return client.getSomeError();
    }

    @GetMapping("otherUsers")
    private List<User> getOtherUsers(){
        return otherClient.getUsers();
    }

    @GetMapping("otherError")
    private String getOtherError(){
        return otherClient.getSomeError();
    }

    @GetMapping("badssl")
    private String getBadsslContent() {
        return badsslClient.getContent();
    }
}
