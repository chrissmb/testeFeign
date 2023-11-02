package com.example.testeFeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class TesteFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesteFeignApplication.class, args);
	}

}
