package com.kozlovskaya.lesson6.repositories;


import com.kozlovskaya.lesson6.data.Customer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface Product6Dao {
    List<Customer> findAllCustomersByProductId(Long id);
}
