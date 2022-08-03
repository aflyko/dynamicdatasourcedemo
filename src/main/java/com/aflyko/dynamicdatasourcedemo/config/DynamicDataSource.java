package com.aflyko.dynamicdatasourcedemo.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DynamicDataSource extends AbstractRoutingDataSource {
    private final DataSource defaultDataSource;
    private final ThreadLocal<String> currentKey = new ThreadLocal<>();
    private final Map<String, DataSource> dataSourceMap = new HashMap<>();

    public DynamicDataSource(DataSource defaultDataSource) {
        this.defaultDataSource = defaultDataSource;
    }

    @Override
    protected String determineCurrentLookupKey() {

        return currentKey.get();
    }


    @Override
    public void afterPropertiesSet() {

    }

    @Override
    protected DataSource determineTargetDataSource() {
        String key = determineCurrentLookupKey();
        if(key ==null){
            return defaultDataSource;
        }
        return dataSourceMap.get(key);
    }

    public void addDataSource(String name, DataSource dataSource) {
        dataSourceMap.put(name, dataSource);
    }

    public void setCurrentKey(String key){
        currentKey.set(key);
    }

    public void reset(){
        currentKey.remove();
    }


}
