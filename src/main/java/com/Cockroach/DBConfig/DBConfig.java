package com.Cockroach.DBConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DBConfig {

    @Lazy
    @Scope("singleton") // Singleton pattern
    @Bean
    public DataSource dataSource() {
        return createDataSource();
    }

    private DataSource createDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://newest-ant-12734.7tt.cockroachlabs.cloud:26257/defaultdb?sslmode=verify-full");
        dataSource.setUsername("tilak");
        dataSource.setPassword("vB_hPJd-nztzVgQW_P12GQ");
        return dataSource;
    }
}
