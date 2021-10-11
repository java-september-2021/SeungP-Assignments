package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

@RestController
public class StringsassignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(StringsassignmentApplication.class, args);
	}

	@RequestMapping("/")
	public String greeting() {
		return "Greetings, client. I hope you are well!";
	}
	
	@RequestMapping("/random")
	public String response() {
		return "Spring Boot is similar to Django for python. It's quite easy to use!";
	}
}
