package com.sapient.productservice.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sapient.productservice.model.Product;

@Repository(value = "mysqlDAOImpl")
public class MySqlProductServiceDaoImpl implements ProductServiceDao{
	
	 	@Autowired
	    private JdbcTemplate jdbcTemplate;


	    public MySqlProductServiceDaoImpl(JdbcTemplate jdbcTemplate){
	        this.jdbcTemplate = jdbcTemplate;
	    }

	    public Product save(Product product) {
	        System.out.println("Came inside the save method of MySQLProductDAOImpl");
	        String query = "insert into product_table (name, price) values ('" + product.getName() + "'," + product.getPrice() + ")";
	        jdbcTemplate.execute(query);
	        return product;
	    }

	    public List<Product> listAll() {
	       System.out.println("Came inside the listAll method of MySQLProductDAOImpl");
	       List<Product> productList = jdbcTemplate.query("select * from product_table",
	               ( rs, rowNum)-> new Product(rs.getInt(1), rs.getString(2), rs.getDouble(3)));
	       return productList;
	    }

	    public Product findById(long id) {
	    	System.out.println("Came inside the findById method of MySQLProductDAOImpl");
	        return jdbcTemplate.queryForObject("select * from product_table where id=" + id,
	                (rs, rowNum) -> {
	                	Product product =  new Product(rs.getInt(1), rs.getString(2), rs.getDouble(3));
	                    return product;
	                });

	    }

	    public void deleteProduct(long id) {
	    	System.out.println("Came inside the deleteProduct method of MySQLProductDAOImpl");
	    	String query = "delete from product_table where id=" + id;
	    	jdbcTemplate.update(query);
	    }
	    
	    public void updateProduct(long id, Product product) {
	    	System.out.println("Came inside the updateProduct method of MySQLProductDAOImpl");
	    	String query = "update product_table set name='" + product.getName() + "', price=" + product.getPrice() + "where id=" + id;
	    	jdbcTemplate.update(query);
	    }
}
