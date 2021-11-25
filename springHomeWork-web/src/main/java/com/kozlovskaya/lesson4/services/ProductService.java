package com.kozlovskaya.lesson4.services;

import com.kozlovskaya.lesson4.data.ProductNew;
import com.kozlovskaya.lesson4.repositories.ProductDaoWeb;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductDaoWeb productDaoWeb;


    public ProductService(ProductDaoWeb productDaoWeb) {
        this.productDaoWeb = productDaoWeb;
    }


    public List<ProductNew> getAllProducts() {
        return productDaoWeb.findAll();
    }

    public void deleteById(Long id) {
        productDaoWeb.deleteById(id);
    }

    public void changeCost(Long id, Integer delta) {
        ProductNew product = productDaoWeb.findById(id);
        product.setCost(product.getCost() + delta);
        productDaoWeb.saveOrUpdate(product);
    }
}
