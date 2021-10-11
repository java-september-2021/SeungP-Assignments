package com.foof.hellohuman.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class HomeController {
	@RequestMapping("/")
	public String index(@RequestParam(value="first_name", required = false) String name, 
						@RequestParam(value="last_name", required=false) String last_name,
						@RequestParam(value="times", required=false) Integer number) {
		String returnStr = "";
		if (number == null) number=1;
		if (name == null && last_name == null) {
			returnStr = "Greetings, human!";
			returnStr = greetingRepeat(returnStr, number);
			return returnStr;
		}
		else if (name != null && last_name == null) {
			returnStr = "Greetings, " + name + "!";
			returnStr = greetingRepeat(returnStr, number);
			return returnStr;
		}
		else {
			returnStr = "Greetings, " + name + " " + last_name + "!";
			returnStr = greetingRepeat(returnStr, number);
			return returnStr;
		}
	}
	
	public String greetingRepeat(String str, int num) {
		String returnStr = "";
		for (int i = 0; i < num; i++) {
			returnStr = returnStr + str + " ";
		}
		return returnStr;
	}
}
