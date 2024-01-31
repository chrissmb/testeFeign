package com.example.testeFeign.rest.config;

import feign.RequestInterceptor;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

import java.util.Date;

public class OtherRestConfig {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> requestTemplate
                .header("Authorization", "Bearer [someJWT]")
                .header("Some-other-date", new Date().toString());
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return new ErrorDecoder() {
            @Override
            public Exception decode(String s, Response response) {
                return new Exception("Other Exception");
            }
        };
    }
}
