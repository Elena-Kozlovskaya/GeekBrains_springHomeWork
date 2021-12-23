package com.kozlovskaya.lesson6.services;

import com.kozlovskaya.lesson6.data.Customer;
import com.kozlovskaya.lesson6.repositories.Product6Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private Product6Dao product6Dao;

    @Autowired
    public void setProduct6Dao(Product6Dao product6Dao) {
        this.product6Dao = product6Dao;
    }


    public List<Customer> findAllCustomersByProductId(Long id) {
        return product6Dao.findAllCustomersByProductId(id);
    }
}
