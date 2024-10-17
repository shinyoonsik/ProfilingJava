package org.example.service;

import org.example.model.MyProduct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class RandomProductService {

    public List<MyProduct> makeMyProduct(int n) {
        List<MyProduct> products = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Random random = new Random();
            int randomPrice = random.nextInt();
            MyProduct myProduct = new MyProduct("과자_" + i, randomPrice);
            products.add(myProduct);
        }

        return products;
    }
}
