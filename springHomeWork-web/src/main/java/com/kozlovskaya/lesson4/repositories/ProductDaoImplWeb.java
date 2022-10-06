package com.kozlovskaya.lesson4.repositories;

import com.kozlovskaya.lesson4.data.ProductNew;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDaoImplWeb implements ProductDaoWeb {
    private final SessionFactoryUtilsWeb sessionFactoryUtilsWeb;


    public ProductDaoImplWeb(SessionFactoryUtilsWeb sessionFactoryUtilsWeb) {
        this.sessionFactoryUtilsWeb = sessionFactoryUtilsWeb;
    }

    @Override
    public ProductNew findById(Long id) {
        try (Session session = sessionFactoryUtilsWeb.getSession()) {
            session.beginTransaction();
            ProductNew product = session.get(ProductNew.class, id);
            session.getTransaction().commit();
            return product;
        }
    }

    @Override
    public List<ProductNew> findAll() {
        try (Session session = sessionFactoryUtilsWeb.getSession()) {
            session.beginTransaction();
            List<ProductNew> products = session.createQuery("select p from ProductNew p").getResultList();
            session.getTransaction().commit();
            return products;
        }
    }

    @Override
    public void saveOrUpdate(ProductNew product) {
        try (Session session = sessionFactoryUtilsWeb.getSession()) {
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = sessionFactoryUtilsWeb.getSession()) {
            session.beginTransaction();
            session.createQuery("delete from ProductNew p where p.id = :id")
                    .setParameter("id", id)
                    .executeUpdate();
            session.getTransaction().commit();
        }
    }

}
