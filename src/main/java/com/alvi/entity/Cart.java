package com.alvi.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(scopeName = "prototype")
public class Cart {

    public List<Product> products;

    public Cart() {
        products = new ArrayList<>();
    }
}
