package com.aflyko.dynamicdatasourcedemo.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DefaultDataSourceConfig {
    @Primary
    @Bean
    public DataSource defaultDataSource(DataSourceProperties dataSourceProperties){
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }
}
