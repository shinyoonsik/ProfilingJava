package org.example.repository.mapper;

import org.example.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();
        product.setId(rs.getInt("ID"));
        product.setName(rs.getString("NAME"));
        product.setPrice(rs.getBigDecimal("PRICE"));
        return product;
    }
}
