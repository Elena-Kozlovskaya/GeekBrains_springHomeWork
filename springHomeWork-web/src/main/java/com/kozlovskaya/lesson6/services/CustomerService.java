package com.kozlovskaya.lesson6.services;

import com.kozlovskaya.lesson6.data.Product6;
import com.kozlovskaya.lesson6.repositories.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private CustomerDao customerDao;

    @Autowired
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }


    public List<Product6> findAllProductsByCustomerId(Long id) {
        return customerDao.findAllProductsByCustomerId(id);
    }


    public List<Integer> findProductCostByCustomerId(Long id) {
        return customerDao.findProductCostByCustomerId(id);
    }
}
