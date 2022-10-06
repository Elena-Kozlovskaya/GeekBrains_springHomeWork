package com.kozlovskaya.lesson6.data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
@NamedQueries({
        @NamedQuery(name = "withProducts", query = "SELECT c FROM Customer c JOIN FETCH c.products WHERE c.id = :id")
})
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(
            name = "customers_products",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product6> products;

    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product6> getProducts() {
        return products;
    }

    public void setProducts(List<Product6> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return String.format("Customer [id = %d, name = %s]", id, name, products.size());
    }
}
