package com.foof.dojooverflow.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.foof.dojooverflow.models.Answer;
import com.foof.dojooverflow.models.Question;
import com.foof.dojooverflow.services.DojoService;

@Controller
public class DojoController {
	private DojoService dService;
	
	public DojoController(DojoService dService) {
		this.dService=dService;
	}
	
	@RequestMapping("/questions")
	public String dashboard(Model model) {
		model.addAttribute("questions", dService.getAllQuestions());
		return "/questions.jsp";
	}
	
	@RequestMapping("/questions/new")
	public String newQuestion(@ModelAttribute("question") Question question) {
		return "/newQuestion.jsp";
	}
	@RequestMapping(value="/questions/new", method=RequestMethod.POST)
	public String createQuestion(@Valid @ModelAttribute("question") Question question, BindingResult result) {
		if (result.hasErrors()) {
			return "/newQuestion.jsp";
		}
		else {
			dService.createQuestion(question);
			dService.processTagQuery(question);
			return "redirect:/questions";
		}
	}
	
	@RequestMapping("/questions/{id}")
	public String question(@ModelAttribute("answer") Answer answer, @PathVariable("id") Long id, Model model ) {
		Question q = dService.getQuestion(id);
		model.addAttribute("thisQuestion", q);
		return "/question.jsp";
	}
	@RequestMapping(value="/questions/{id}/new", method=RequestMethod.POST)
	public String createAnswer(@Valid @ModelAttribute("answer") Answer answer, BindingResult result, @PathVariable("id") Long id, Model model) {
		Question q = dService.getQuestion(id);
		if (result.hasErrors()) {
			model.addAttribute("thisQuestion", q);
			return "/question.jsp";
		}
		else {
			dService.createAnswer(answer.getAnswerText(), q);
			return "redirect:/questions/"+id;
		}
	}
}
