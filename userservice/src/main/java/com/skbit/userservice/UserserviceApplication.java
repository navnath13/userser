package com.skbit.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController("/user")
public class UserserviceApplication {
	
	@GetMapping("/")
    public String getMessage() {
    	return "this is project is deployed ond server";
    }
	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

}
