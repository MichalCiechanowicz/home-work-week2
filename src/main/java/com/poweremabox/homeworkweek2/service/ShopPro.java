package com.poweremabox.homeworkweek2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@ConfigurationProperties(prefix = "shop-pro")
public class ShopPro {

    private ShopService shopService;
    private int vat;
    private double discount;

    @Autowired
    public ShopPro(ShopService shopService) {
        this.shopService = shopService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public int showPrice() {
        int totalPrice = shopService.getTotalPrice();
        System.out.println("Discount price "
                + totalPrice * (1 + (vat / 100) * discount * 100));
        return totalPrice;
    }

    public void setVat(int vat) {
        this.vat = vat;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getVat() {
        return vat;
    }

    public double getDiscount() {
        return discount;
    }
}
