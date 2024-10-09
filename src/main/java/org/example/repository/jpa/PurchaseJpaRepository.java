package org.example.repository.jpa;

import org.example.model.JpaPurchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseJpaRepository extends JpaRepository<JpaPurchase, Integer> {
}
