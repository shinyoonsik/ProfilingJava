package org.example.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueryDslJpaConfig {
    private final EntityManager entityManager;

    public QueryDslJpaConfig(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    // jpa QueryDSL을 사용하려면 JPAQueryFactory를 Bean으로 등록해야 함
    @Bean
    public JPAQueryFactory jpaQueryFactory(){
        return new JPAQueryFactory(this.entityManager);
    }
}
