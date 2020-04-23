package com.poweremabox.homeworkweek2.model;

import java.util.Random;

public class Product {

    private String name;
    private int price;

    public Product(){

    }
    public Product(String name, int price) {
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
        Random random = new Random();
        return price = random.nextInt((300-50)+1)+50;

    }

    public void setPrice(int price) {
        this.price = price;
    }
}