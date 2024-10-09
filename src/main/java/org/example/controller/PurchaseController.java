package org.example.controller;

import org.example.service.PurchaseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class PurchaseController {

    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping("/purchased-products")
    public Set<String> findProducts(){
        return this.purchaseService.getProductNames();
    }

    @GetMapping("/jpa/purchased-products")
    public Set<String> findProductsByJpa(){
        return this.purchaseService.getProductNamesByJpa();
    }
}
