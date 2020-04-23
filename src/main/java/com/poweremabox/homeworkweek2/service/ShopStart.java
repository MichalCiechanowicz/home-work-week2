package com.poweremabox.homeworkweek2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class ShopStart{

    private ShopService shopService;

    @Autowired
    public ShopStart(ShopService shopService) {
        this.shopService = shopService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public int showPrice() {
        int totalPrice = shopService.getTotalPrice();
        System.out.println("Net price " + totalPrice);
        return totalPrice;
    }

}
