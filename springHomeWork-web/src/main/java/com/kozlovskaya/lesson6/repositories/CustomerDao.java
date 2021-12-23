package com.kozlovskaya.lesson6.repositories;

import com.kozlovskaya.lesson6.data.Product6;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CustomerDao {
    List<Product6> findAllProductsByCustomerId(Long id);

    List<Integer> findProductCostByCustomerId(Long id);
}
