package com.sapient.productservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.productservice.dao.ProductServiceDao;
import com.sapient.productservice.model.Product;
import com.sapient.productservice.repository.ProductRepository;

@Service(value = "productService")
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	@Qualifier(value = "hibernateDAOImpl")
	private ProductServiceDao productServiceDao;
	
	@Autowired
	private ProductRepository productRepository;
	
//	public ProductServiceImpl(@Qualifier(value = "hibernateDAOImpl") ProductServiceDao productServiceDao) {
//		this.productServiceDao = productServiceDao;
//	}
	
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@Transactional
	 public Product saveProduct(Product product) {
		 System.out.println("Inside the save product method of Product service class ....");
	     return this.productRepository.save(product);
	 }
	
	@Transactional
	 public List<Product> fetchAllProduct() {
		 System.out.println("Inside the fetchAll product method of Product service class ....");
	     return (List<Product>) this.productRepository.findAll();
	 }
	
	@Transactional
	 public Product findById(long id) {
		 System.out.println("Inside the findById method of Product service class ....");
		 Optional<Product> optionalProduct = this.productRepository.findById(id);
		 if(optionalProduct.isPresent()) {
			 return optionalProduct.get();
		 }
		 throw new IllegalArgumentException("Employee Not Found");
	 }

	@Transactional
	 public void deleteProduct(long id) {
		 System.out.println("Inside the delete product method of Product service class ....");
		 this.productRepository.deleteById(id);;
	 }
	 
	@Transactional
	 public void updateProduct(long id, Product p) {
		 System.out.println("Inside the update product method of Product service class ....");
		 Optional<Product> optionalProduct = this.productRepository.findById(id);
		 if(optionalProduct.isPresent()) {
			 Product p1 = optionalProduct.get();
			 p1.setName(p.getName());
			 p1.setPrice(p.getPrice());
			 this.productRepository.save(p1);
		 }
	 }
}
