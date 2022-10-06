package com.kozlovskaya.lesson6.repositories;

import com.kozlovskaya.lesson6.data.Customer;
import com.kozlovskaya.lesson6.data.Product6;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerDaoImpl implements CustomerDao {

    private SessionFactoryUtils6 sessionFactoryUtils;


    @Autowired
    public void setSessionFactoryUtils(SessionFactoryUtils6 sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }


    @Override
    public List<Product6> findAllProductsByCustomerId(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Customer customer = session.get(Customer.class, id);
            List<Product6> products = customer.getProducts();
            System.out.println(products);
            session.getTransaction().commit();
            return products;
        }
    }

    public List<Integer> findProductCostByCustomerId(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Customer customer = session.get(Customer.class, id);
            List<Product6> products = customer.getProducts();
            List<Integer> costs = new ArrayList<>();
            for (Product6 product : products) {
                costs.add(product.getCost());
            }
            session.getTransaction().commit();
            return costs;
        }
    }

}
