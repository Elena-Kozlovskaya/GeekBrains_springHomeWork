package com.kozlovskaya.lesson4.data;

public class Product {

    private Long id;
    private String title;
    private Integer cost;

    public Product() {
    }

    public Product(Long id, String title, Integer cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}