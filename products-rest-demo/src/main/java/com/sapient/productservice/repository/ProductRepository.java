package com.sapient.productservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sapient.productservice.model.Product;

@Repository("productRepository")
public interface ProductRepository extends CrudRepository <Product, Long>{

}
