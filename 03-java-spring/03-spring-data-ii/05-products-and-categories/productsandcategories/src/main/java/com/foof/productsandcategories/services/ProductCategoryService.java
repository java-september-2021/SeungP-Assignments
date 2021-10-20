package com.foof.productsandcategories.services;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foof.productsandcategories.models.Category;
import com.foof.productsandcategories.models.Product;
import com.foof.productsandcategories.repositories.CategoryRepository;
import com.foof.productsandcategories.repositories.ProductRepository;

@Service
public class ProductCategoryService {
	@Autowired
	private ProductRepository pRepository;
	private CategoryRepository cRepository;
	//Constructor
	public ProductCategoryService(ProductRepository pRepository, CategoryRepository cRepository) {
		this.pRepository = pRepository;
		this.cRepository = cRepository;
	}
	
	//Find methods
	public List<Product> getAllProducts(){
		return this.pRepository.findAll();
	}
	
	public Product getProduct(Long id) {
		return this.pRepository.findById(id).orElse(null);
	}
	
	public List<Category> getAllCategories(){
		return this.cRepository.findAll();
	}
	
	public Category getCategory(Long id) {
		return this.cRepository.findById(id).orElse(null);
	}
	
	public List<Category> findAllByProducts(Product product){
		List<Category> listC = new ArrayList<Category>();
		List<Category> fullC = getAllCategories();
    	for(Category c:fullC) {
    		if (c.getProducts().contains(product)) {
    			listC.add(c);
    		}
    	}
    	return listC;
	}
    public List<Category> findByProductsNotContains(Product product){
    	List<Category> listC = getAllCategories();
    	for(Category c:product.getCategories()) {
    		if (c.getProducts().contains(product)) {
    			listC.remove(c);
    		}
    	}
    	return listC;
    }
    public List<Product> findByCategoriesNotContains(Category category){
    	List<Product> listP = getAllProducts();
    	for(Product p:category.getProducts()) {
    		if (p.getCategories().contains(category)) {
    			listP.remove(p);
    		}
    	}
    	return listP;
    }
    
	//Create
	public Product createProduct(Product p) {
		return this.pRepository.save(p);
	}
	public Category createCategory(Category c) {
		return this.cRepository.save(c);
	}
	
	//Update
	public Product updateProduct(Long id, String name, String description, float price, List<Category> categories) {
		Product p = getProduct(id);
		p.setName(name);
		p.setDescription(description);
		p.setPrice(price);
		p.setCategories(categories);
		return pRepository.save(p);
	}
	public Category updateCategory(Long id, String name, List<Product> products) {
		Category c = getCategory(id);
		c.setName(name);
		c.setProducts(products);
		return cRepository.save(c);
	}
	public Product updateProduct(@Valid Product product) {
		Product p = getProduct(product.getId());
		p.setName(product.getName());
		p.setDescription(product.getDescription());
		p.setPrice(product.getPrice());
		p.setCategories(product.getCategories());
		return pRepository.save(p);
	}
	public Category updateCategory(@Valid Category category) {
		Category c = getCategory(category.getId());
		c.setName(category.getName());
		c.setProducts(category.getProducts());
		return cRepository.save(c);
	}
	public void addRelationship(Long categoryId, Long productId) {
		Category thisC = getCategory(categoryId);
		Product thisP = getProduct(productId);
		thisC.getProducts().add(thisP);
		cRepository.save(thisC);
	}
	
	//Delete
	public void deleteProduct(Long id) {
		pRepository.deleteById(id);
	}
	public void deleteCategory(Long id) {
		cRepository.deleteById(id);
	}
}
