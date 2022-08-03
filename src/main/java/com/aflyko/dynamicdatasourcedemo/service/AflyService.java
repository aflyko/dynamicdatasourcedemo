package com.aflyko.dynamicdatasourcedemo.service;

import com.aflyko.dynamicdatasourcedemo.config.DynamicDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class AflyService {
    private final DynamicDataSource dynamicDataSource;
    private final JdbcTemplate jdbcTemplate;

    public AflyService(DynamicDataSource dynamicDataSource, JdbcTemplate jdbcTemplate) {
        this.dynamicDataSource = dynamicDataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    public void dynamicDataSourceTest() {
        try {
            List<Map<String, Object>> defaultUsers = jdbcTemplate.queryForList("select * from USER ");
            log.info("默认数据源users" + defaultUsers);
            dynamicDataSource.setCurrentKey("secondDataSource");
            List<Map<String, Object>> secondDataSourceUsers = jdbcTemplate.queryForList("select * from USER ");
            log.info("第二数据源users" + secondDataSourceUsers);
        } catch (Exception exception) {
            log.error(exception.getMessage());
        } finally {
            dynamicDataSource.reset();
        }
        try {
            dynamicDataSource.setCurrentKey("thirdDataSource");
            List<Map<String, Object>> thirdDataSourceUsers = jdbcTemplate.queryForList("select * from USER ");
            log.info("第三数据源users" + thirdDataSourceUsers);
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            dynamicDataSource.reset();
        }


    }
}
