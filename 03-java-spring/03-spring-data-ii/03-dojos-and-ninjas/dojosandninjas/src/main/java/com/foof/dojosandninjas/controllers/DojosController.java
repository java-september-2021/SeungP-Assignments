package com.foof.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.foof.dojosandninjas.models.Dojo;
import com.foof.dojosandninjas.models.Ninja;
import com.foof.dojosandninjas.services.DojoService;
import com.foof.dojosandninjas.services.NinjaService;

@Controller
public class DojosController {
	private final DojoService dojoService;
	private final NinjaService ninjaService;
	
	public DojosController(DojoService dojoService, NinjaService ninjaService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}
	
	@RequestMapping("/")
	public String indexRedirect() {
		return "redirect:/dojos/new";
	}
	@RequestMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "/dojosandninjas/newDojo.jsp";
	}
	@RequestMapping(value="/dojos/new", method=RequestMethod.POST)
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "/dojosandninjas/newDojo.jsp";
		}
		else {
			dojoService.createDojo(dojo);
			return "redirect:/ninjas/new";
		}
	}
	@RequestMapping("/ninjas/new")
	public String newNinja(Model model, @ModelAttribute("ninja") Ninja ninja) {
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		return "/dojosandninjas/newNinja.jsp";
	}
	@RequestMapping(value="/ninjas/new", method=RequestMethod.POST)
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		if (result.hasErrors()) {
			return "/dojosandninjas/newNinja.jsp";
		}
		else {
			ninjaService.createNinja(ninja);
			return "redirect:/dojos/" + ninja.getDojo().getId();
		}
	}
	@RequestMapping("/dojos/{id}")
	public String dojo(@PathVariable("id") Long id, Model model) {
		Dojo d = dojoService.findDojo(id);
		model.addAttribute("dojo", d);
		model.addAttribute("ninjas", d.getNinjas());
		return "/dojosandninjas/dojo.jsp";
	}
}
