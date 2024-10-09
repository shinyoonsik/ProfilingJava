package org.example.repository.jpa;

import org.example.model.JpaProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository<JpaProduct, Integer> {
}
