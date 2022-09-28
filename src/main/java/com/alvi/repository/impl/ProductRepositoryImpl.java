package com.alvi.repository.impl;

import com.alvi.entity.Cart;
import com.alvi.entity.Product;
import com.alvi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductRepositoryImpl implements ProductRepository {

    public Cart cart;

    @Autowired
    public ProductRepositoryImpl(Cart cart) {
        this.cart = cart;
    }

    public ProductRepositoryImpl() {
    }

    List<Product> products;


    @PostConstruct
    public void init() {
        products = new ArrayList<>(Arrays.asList(
                new Product(1, "Яблоко", 20),
                new Product(2, "Арбуз", 120),
                new Product(3, "Апельсин", 10),
                new Product(4, "Киви", 30),
                new Product(5, "Банан", 25)
        ));
    }

    @Override
    public Product findById(int id) {
        return products.stream()
                .filter(i -> i.getId() == id).findFirst().get();
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void addToCart(int id) {
        Product product = products.stream().filter(i -> i.getId() == id).findFirst().get();
        cart.products.add(product);
        System.out.println("Вы успешно добавили товар " + cart.products + " в корзину");
    }
}
