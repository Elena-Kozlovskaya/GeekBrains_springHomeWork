package com.kozlovskaya.lesson4.repositories;

import com.kozlovskaya.lesson4.data.ProductNew;

import java.util.List;

public interface ProductDaoWeb {
    ProductNew findById(Long id);

    List<ProductNew> findAll();

    void deleteById(Long id);

    void saveOrUpdate(ProductNew product);


}
