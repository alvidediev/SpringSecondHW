package com.alvi.repository;

import com.alvi.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository {

     Product findById(int id);

     List<Product> findAll();

     void addToCart(int id);
}
