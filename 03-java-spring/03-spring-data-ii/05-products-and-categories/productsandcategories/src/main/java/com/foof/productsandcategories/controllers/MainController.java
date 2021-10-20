package com.foof.productsandcategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.foof.productsandcategories.models.Category;
import com.foof.productsandcategories.models.Product;
import com.foof.productsandcategories.services.ProductCategoryService;

@Controller
public class MainController {
	private ProductCategoryService pcService;
	
	public MainController(ProductCategoryService pcService) {
		this.pcService=pcService;
	}
	
	@RequestMapping("/")
	public String indexRedirect() {
		return "redirect:/products/new";
	}
	//New and create pages
	@RequestMapping("/products/new")
		public String newProduct(@ModelAttribute("product") Product product) {
		return "/newProduct.jsp";
	}
	@RequestMapping(value="/products/new", method=RequestMethod.POST)
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "/newProduct.jsp";
		}
		else {
			pcService.createProduct(product);
			return "redirect:/products/" + product.getId();
		}
	}
	
	@RequestMapping("/categories/new")
	public String newCategory(@ModelAttribute("category") Category category) {
	return "/newCategory.jsp";
	}
	@RequestMapping(value="/categories/new", method=RequestMethod.POST)
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if (result.hasErrors()) {
			return "/newCategory.jsp";
		}
		else {
			pcService.createCategory(category);
			return "redirect:/categories/" + category.getId();
		}
	}
	//Info pages
	@RequestMapping("/products/{id}")
	public String product(@PathVariable("id") Long id, Model model, @ModelAttribute("category") Category category) {
		Product p = pcService.getProduct(id);
		model.addAttribute("product",p);
		model.addAttribute("productCategories", p.getCategories());
		List<Category> nonIncludedCategories = pcService.findByProductsNotContains(p);
		model.addAttribute("nonIncludedCategories", nonIncludedCategories);
		System.out.println(nonIncludedCategories);
		return "/product.jsp";
	}
	@RequestMapping(value="/products/{id}", method=RequestMethod.PUT)
	public String addCategory(@Valid @ModelAttribute("category") Category category, 
							  BindingResult result, 
							  Model model, 
							  @PathVariable("id") Long id) {
		if (result.hasErrors()) {
			return "/product.jsp";
		}
		else {
			pcService.addRelationship(category.getId(), id);
			Product p = pcService.getProduct(id);
			model.addAttribute("product",p);
			model.addAttribute("productCategories", p.getCategories());
			return "redirect:/products/" + id;
		}
	}
	
	@RequestMapping("/categories/{id}")
	public String category(@PathVariable("id") Long id, Model model, @ModelAttribute("product") Product product) {
		Category c = pcService.getCategory(id);
		model.addAttribute("category",c);
		model.addAttribute("categoryProducts", c.getProducts());
		List<Product> nonIncludedProducts = pcService.findByCategoriesNotContains(c);
		model.addAttribute("nonIncludedProducts", nonIncludedProducts);
		return "/category.jsp";
	}
	@RequestMapping(value="/categories/{id}", method=RequestMethod.PUT)
	public String addCategory(@Valid @ModelAttribute("product") Product product, 
							  BindingResult result, 
							  Model model, 
							  @PathVariable("id") Long id) {
		if (result.hasErrors()) {
			return "/category.jsp";
		}
		else {
			pcService.addRelationship(id, product.getId());
			Category c = pcService.getCategory(id);
			model.addAttribute("category",c);
			model.addAttribute("categoryProducts", c.getProducts());
			return "redirect:/category/" + id;
		}
	}
	
}
