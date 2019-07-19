package com.sapient.productservice.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product_details")
public class ProductDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String brand;

    @Override
    public String toString() {
        return "ProductDetails{" +
                "id=" + id +
                ", brand='" + brand +
                '}';
    }
}
