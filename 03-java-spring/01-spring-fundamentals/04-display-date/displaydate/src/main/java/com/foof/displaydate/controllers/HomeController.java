package com.foof.displaydate.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String date(Model model) {
		Date currentDate = new Date(1832225400000L);
		DateFormat formatter = new SimpleDateFormat("EEEE, 'the' dd 'of' MMMM, yyyy");
		model.addAttribute("date", formatter.format(currentDate));
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model model) {
		Date currentDate = new Date(1832225400000L);
		DateFormat formatter = new SimpleDateFormat("h:mm a");
		model.addAttribute("date", formatter.format(currentDate));
		return "time.jsp";
	}
}
