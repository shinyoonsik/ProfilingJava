package org.example.controller;


import org.example.model.MyProduct;
import org.example.service.RandomProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RandomProductController {

    private final RandomProductService randomProductService;

    public RandomProductController(RandomProductService randomProductService) {
        this.randomProductService = randomProductService;
    }


    @GetMapping("/products/{n}")
    public List<MyProduct> getProducts(@PathVariable int n){
        return this.randomProductService.makeMyProduct(n);
    }
}
