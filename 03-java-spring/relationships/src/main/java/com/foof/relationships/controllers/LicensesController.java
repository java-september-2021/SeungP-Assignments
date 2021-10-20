package com.foof.relationships.controllers;

import org.springframework.stereotype.Controller;

import com.foof.relationships.services.LicenseService;
import com.foof.relationships.services.PersonService;

@Controller
public class LicensesController {
	private final LicenseService licenseService;
	private final PersonService personService;
	
	public LicensesController(LicenseService licenseService, PersonService personService) {
		this.licenseService = licenseService;
		this.personService = personService;
	}
}
