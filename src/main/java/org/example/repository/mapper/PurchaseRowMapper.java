package org.example.repository.mapper;

import org.example.model.Purchase;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PurchaseRowMapper implements RowMapper<Purchase> {
    @Override
    public Purchase mapRow(ResultSet rs, int rowNum) throws SQLException {
        Purchase purchase = new Purchase();
        purchase.setId(rs.getInt("ID"));
        purchase.setUserId(rs.getInt("USER_ID"));
        purchase.setProductId(rs.getInt("PRODUCT_ID"));
        return purchase;
    }
}
