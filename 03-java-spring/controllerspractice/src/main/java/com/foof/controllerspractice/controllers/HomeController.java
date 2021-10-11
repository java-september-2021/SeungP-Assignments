package com.foof.controllerspractice.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class HomeController {
	@RequestMapping("/")
	public String index(@RequestParam(value="q", required = false) String searchQuery) {
		return "You searched for: " + searchQuery;
	}
	
	@RequestMapping("/{page}")
	public String page(@PathVariable("page") String pageNumber) {
		return "This is page number: " + pageNumber;
	}
}
