package com.aflyko.dynamicdatasourcedemo.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "aflyko")
@Configuration
public class ExtraDataSourceConfig {
    private List<Map<String, String>> extradatasources;

    public void setExtradatasources(List<Map<String, String>> extradatasources) {
        this.extradatasources = extradatasources;
    }
    @Bean
    public DataSource secondDataSource(){
        Map<String, String> dataSourceConfig = extradatasources.get(0);
        return DataSourceBuilder.create().type(HikariDataSource.class)
                .url(dataSourceConfig.get("url"))
                .driverClassName(dataSourceConfig.get("driverClassName"))
                .username(dataSourceConfig.get("username"))
                .password(dataSourceConfig.get("password"))
                .build();
    }
    @Bean
    public DataSource thirdDataSource(){
        Map<String, String> dataSourceConfig = extradatasources.get(1);
        return DataSourceBuilder.create().type(HikariDataSource.class)
                .url(dataSourceConfig.get("url"))
                .driverClassName(dataSourceConfig.get("driverClassName"))
                .username(dataSourceConfig.get("username"))
                .password(dataSourceConfig.get("password"))
                .build();
    }
}
