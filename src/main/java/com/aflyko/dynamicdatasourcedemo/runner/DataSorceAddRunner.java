package com.aflyko.dynamicdatasourcedemo.runner;

import com.aflyko.dynamicdatasourcedemo.config.DynamicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class DataSorceAddRunner implements CommandLineRunner {
    private final DataSource secondDataSorce;
    private final DataSource thirdDataSource;
    private final DynamicDataSource dynamicDataSource;

    public DataSorceAddRunner(@Qualifier("secondDataSource") DataSource secondDataSorce, @Qualifier("thirdDataSource") DataSource thirdDataSource, DynamicDataSource dynamicDataSource) {
        this.secondDataSorce = secondDataSorce;
        this.thirdDataSource = thirdDataSource;
        this.dynamicDataSource = dynamicDataSource;
    }

    @Override
    public void run(String... args){
        dynamicDataSource.addDataSource("secondDataSource", secondDataSorce);
        dynamicDataSource.addDataSource("thirdDataSource", thirdDataSource);
    }
}
