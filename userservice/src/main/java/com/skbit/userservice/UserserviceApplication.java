package com.skbit.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController("/users")
public class UserserviceApplication {
	
	@GetMapping("/")
    public String getMessage() {
    	return "nice job you can do it ";
    }
	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

}
