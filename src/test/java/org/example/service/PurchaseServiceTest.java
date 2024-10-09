package org.example.service;

import org.example.model.JpaProduct;
import org.example.model.Product;
import org.example.repository.ProductRepository;
import org.example.repository.PurchaseRepository;
import org.example.repository.jpa.ProductJpaRepository;
import org.example.repository.jpa.PurchaseJpaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.StopWatch;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PurchaseServiceTest {

    List<JpaProduct> jpaProducts = new ArrayList<>();
    List<Product> products = new ArrayList<>();

    @MockBean
    private PurchaseRepository purchaseRepository;

    @MockBean
    private PurchaseJpaRepository purchaseJpaRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductJpaRepository productJpaRepository;

    @Autowired
    private PurchaseService purchaseService;

    @BeforeEach
    void init() {
        for (int i = 0; i < 1000; i++) {
            jpaProducts.add(new JpaProduct("jpa 콜라 " + i, new BigDecimal(1000 + i)));
        }

        for (int i = 0; i < 1000; i++) {
            products.add(new Product("콜라 " + i, new BigDecimal(1000 + i)));
        }
    }

    @Test
    @DisplayName("spring data jpa의 saveAll()")
    void saveProductsByJpa() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        List<JpaProduct> result = this.purchaseService.saveProductsByJpa(jpaProducts);
        stopWatch.stop();

        System.out.println("JPA 걸린 시간:" + stopWatch.getTotalTime(TimeUnit.SECONDS));
        assertThat(result).isNotNull();
    }

    @Test
    @DisplayName("spring data jdbc를 활용한 bulkInsert")
    void saveProductsByJdbc() {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        int[] result = this.purchaseService.saveProductsByJDBC(products);
        stopWatch.stop();

        System.out.println("걸린시간 = " + stopWatch.getTotalTime(TimeUnit.SECONDS));
        assertThat(result).isNotNull();
    }
}