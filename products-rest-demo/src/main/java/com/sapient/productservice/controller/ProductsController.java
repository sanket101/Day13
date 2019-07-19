package com.sapient.productservice.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sapient.productservice.model.*;
import com.sapient.productservice.service.ProductService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

@RestController
@RequestMapping("/api/v1/products/")
//@EnableSwagger2
public class ProductsController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping(value="/", produces= {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
	//@ApiOperation(value = "Fetch all employees", notes = "API to fetch all the employees")
	public List<Product> listAll(){
		List<Product> products = this.productService.fetchAllProduct();
		return products;
	}
	
	//Here path variable is specified by annotation so as to inform/map the variable 'id' with url link(get mapping) 
	@GetMapping(value="/{id}", produces= {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
	@ExceptionHandler(IllegalArgumentException.class)
	public Product findById(@ApiParam(value = "${ProductController.getProductById}", required = true) @PathVariable("id") int id) {
		Product p = this.productService.findById(id);
		return p;
	}
	
	@PostMapping(value="/", consumes = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
	public void saveProduct(@Valid @RequestBody Product product) {
		System.out.println("Inside saveProduct..");
		this.productService.saveProduct(product);
	}
	
	@PutMapping(value="/{id}", consumes = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
	public void updateProduct(@PathVariable int id, @RequestBody Product product) {
		System.out.println("Came inside update product method");
		this.productService.updateProduct(id, product);
	}
	
	@PostMapping(value="/{id}")
	public void deleteProduct(@PathVariable int id) {
		System.out.println("Deleted the product successfully");
		this.productService.deleteProduct(id);
	}
}
