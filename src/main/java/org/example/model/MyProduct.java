package org.example.model;

import java.math.BigDecimal;

public class MyProduct {

    private int id;
    private String name;
    private int price;

    public MyProduct() {
    }

    public MyProduct(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
