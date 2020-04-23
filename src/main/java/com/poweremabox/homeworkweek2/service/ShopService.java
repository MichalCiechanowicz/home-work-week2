package com.poweremabox.homeworkweek2.service;

import com.poweremabox.homeworkweek2.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopService {

    private List<Product> productsBasket;
    private Product product;

    public ShopService() {
        productsBasket = new ArrayList<>();
        product = new Product();
        productsBasket.add(new Product("Rower", product.getPrice()));
        productsBasket.add(new Product("Miska", product.getPrice()));
        productsBasket.add(new Product("Walek", product.getPrice()));
        productsBasket.add(new Product("Dywan", product.getPrice()));
    }


    public int getTotalPrice() {
        int sum = 0;
        for (Product product : productsBasket) {
            sum += product.getPrice();
        }
        return sum;
    }

    public List<Product> getProductsBasket() {
        return productsBasket;
    }

    public void setProductsBasket(List<Product> productsBasket) {
        this.productsBasket = productsBasket;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
