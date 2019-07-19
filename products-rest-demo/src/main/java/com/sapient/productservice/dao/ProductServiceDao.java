package com.sapient.productservice.dao;

import java.util.List;

import com.sapient.productservice.model.Product;

public interface ProductServiceDao {
	
	public Product save(Product product);

    public List<Product> listAll();

    public Product findById(long id);

    public void deleteProduct(long id);
    
    public void updateProduct(long id, Product product);
}
