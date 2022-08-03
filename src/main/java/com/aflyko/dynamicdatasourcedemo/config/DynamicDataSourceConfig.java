package com.aflyko.dynamicdatasourcedemo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import javax.sql.DataSource;

@Configuration
public class DynamicDataSourceConfig {

    @Bean
    public DynamicDataSource dynamicDataSource(@Qualifier("defaultDataSource") DataSource dataSource){
        return new DynamicDataSource(dataSource);
    }
}
