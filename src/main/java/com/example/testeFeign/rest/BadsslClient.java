package com.example.testeFeign.rest;

import com.example.testeFeign.rest.config.BadsslRestConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "badssl", url = "${badssl.url.base}", configuration = BadsslRestConfig.class)
public interface BadsslClient {

    @GetMapping
    public String getContent();
}
