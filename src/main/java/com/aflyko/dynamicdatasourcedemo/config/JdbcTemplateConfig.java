package com.aflyko.dynamicdatasourcedemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class JdbcTemplateConfig {
    @Bean
    public JdbcTemplate jdbcTemplate(DynamicDataSource dynamicDataSource){
       return new JdbcTemplate(dynamicDataSource);
    }
}
