package org.example.repository;

import org.example.model.Purchase;
import org.example.repository.mapper.PurchaseRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PurchaseRepository {

    private final JdbcTemplate jdbcTemplate;

    public PurchaseRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Purchase> findAll(){
        String sql = "SELECT * FROM PURCHASE";
        return this.jdbcTemplate.query(sql, new PurchaseRowMapper());
    }
}
