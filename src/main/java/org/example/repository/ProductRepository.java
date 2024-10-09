package org.example.repository;

import org.example.model.Product;
import org.example.repository.mapper.ProductRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {
    private final JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public ProductRepository(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public Product findProduct(int id) {
        String sql = "SELECT * FROM PRODUCT WHERE ID = ?";
        return this.jdbcTemplate.queryForObject(sql, new ProductRowMapper(), id);
    }

    public int[] insertProducts(List<Product> products) {
        String sql = """
                insert into product (name, price)
                values(:name, :price)""";

        SqlParameterSource[] params = products.stream()
                .map(BeanPropertySqlParameterSource::new)
                .toArray(SqlParameterSource[]::new);

        return this.namedParameterJdbcTemplate.batchUpdate(sql, params);
    }
}
