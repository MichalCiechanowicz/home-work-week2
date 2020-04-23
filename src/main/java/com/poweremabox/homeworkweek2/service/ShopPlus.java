package com.poweremabox.homeworkweek2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@Profile("plus")
public class ShopPlus {

    private ShopService shopService;

    @Value("${shop-plus.vat}")
    private int vat;

    @Autowired
    public ShopPlus(ShopService shopService) {
        this.shopService = shopService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public int showPrice() {
        int totalPrice = shopService.getTotalPrice();
        System.out.println("Gross price " + totalPrice * (1 + (vat / 100)) + " with " + vat + "vat");
        return totalPrice;
    }

    public void setVat(int vat) {
        this.vat = vat;
    }

}
