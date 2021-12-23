package com.kozlovskaya.lesson6;


import com.kozlovskaya.lesson6.services.CustomerService;
import com.kozlovskaya.lesson6.services.ProductService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CustomersApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.kozlovskaya.lesson6");
        ProductService productService = context.getBean(ProductService.class);
        CustomerService customerService = context.getBean(CustomerService.class);

        try {
            productService.findAllCustomersByProductId(2L);
            customerService.findAllProductsByCustomerId(3L);
            System.out.println(customerService.findProductCostByCustomerId(2L));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
