package com.kozlovskaya.lesson5;


public class MainApp {
    public static void main(String[] args) {
        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();

        try{
            ProductDao productDao = new ProductDaoImpl(sessionFactoryUtils);
            Product product = productDao.findById(3L);
            System.out.println(product);
            System.out.println(productDao.findAll());
            product.setCost(467);
            productDao.saveOrUpdate(product);
            productDao.saveOrUpdate(new Product("Orange", 156));
            productDao.saveOrUpdate(new Product(5L,"Orange", 156));
            productDao.deleteById(1L);
            System.out.println(productDao.findAll());

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            sessionFactoryUtils.shutdown();
        }
    }
}
