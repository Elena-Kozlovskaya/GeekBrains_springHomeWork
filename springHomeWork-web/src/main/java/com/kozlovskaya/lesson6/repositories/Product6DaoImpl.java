package com.kozlovskaya.lesson6.repositories;

import com.kozlovskaya.lesson6.data.Customer;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Product6DaoImpl implements Product6Dao {
    private SessionFactoryUtils6 sessionFactoryUtils;


    @Autowired
    public void setSessionFactoryUtils(SessionFactoryUtils6 sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }


    @Override
    public List<Customer> findAllCustomersByProductId(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<Customer> customers = session.createQuery("select p.customers from Product6 p  where p.id = :id")
                    .setParameter("id", id)
                    .getResultList();
            System.out.println(customers);
            session.getTransaction().commit();
            return customers;
        }
    }
}
