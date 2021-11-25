package com.kozlovskaya.lesson5;

import java.util.List;

public interface ProductDao {
    Product findById(Long id);

    List<Product> findAll();

    void deleteById(Long id);

    void saveOrUpdate(Product product);


}
