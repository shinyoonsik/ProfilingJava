package org.example.service;

import org.example.model.JpaProduct;
import org.example.model.JpaPurchase;
import org.example.model.Product;
import org.example.model.Purchase;
import org.example.repository.ProductRepository;
import org.example.repository.PurchaseRepository;
import org.example.repository.jpa.ProductJpaRepository;
import org.example.repository.jpa.PurchaseJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class PurchaseService {
    private final ProductRepository productRepository;
    private final PurchaseRepository purchaseRepository;
    private final ProductJpaRepository productJpaRepository;
    private final PurchaseJpaRepository purchaseJpaRepository;

    public PurchaseService(ProductRepository productRepository, PurchaseRepository purchaseRepository,
                           ProductJpaRepository productJpaRepository, PurchaseJpaRepository purchaseJpaRepository) {
        this.productRepository = productRepository;
        this.purchaseRepository = purchaseRepository;
        this.productJpaRepository = productJpaRepository;
        this.purchaseJpaRepository = purchaseJpaRepository;
    }

    public Set<String> getProductNames() {
        HashSet<String> productNames = new HashSet<>();
        for (Purchase purchase : this.purchaseRepository.findAll()) {
            Product product = this.productRepository.findProduct(purchase.getProductId());
            productNames.add(product.getName());
        }
        return productNames;
    }

    public Set<String> getProductNamesByJpa() {
        HashSet<String> productNames = new HashSet<>();
        for (JpaPurchase purchase : this.purchaseJpaRepository.findAll()) {
            Optional<JpaProduct> jpaProduct = this.productJpaRepository.findById(purchase.getProductId());
            jpaProduct.ifPresent(product -> productNames.add(product.getName()));
        }
        return productNames;
    }

    @Transactional
    public List<JpaProduct> saveProductsByJpa(List<JpaProduct> products){
        // 하나의 트랜잭션 안에서 for문을 돌며 list의 원소만큼 Insert문을 만들어서 전송한다
        if(!products.isEmpty()) return this.productJpaRepository.saveAll(products);
        else return Collections.emptyList();
    }

    @Transactional
    public int[] saveProductsByJDBC(List<Product> products){
        // 하나의 트랜잭션 안에서 insert...values() 하나의 쿼리문이 실행됨
        int[] result = this.productRepository.insertProducts(products);
        return result;
    }

}
