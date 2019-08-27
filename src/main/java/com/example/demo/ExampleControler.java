package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class ExampleControler {
	@Autowired
	Environment environment;

	
	@GetMapping("/status")
	public String getUsers() {

		return "Hi There , i am running Successfully and running on port " + environment.getProperty("local.server.port");
	}

}

