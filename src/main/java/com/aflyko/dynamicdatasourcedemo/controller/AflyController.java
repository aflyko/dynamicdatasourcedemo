package com.aflyko.dynamicdatasourcedemo.controller;

import com.aflyko.dynamicdatasourcedemo.service.AflyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AflyController {
    private final AflyService aflyService;

    public AflyController(AflyService aflyService) {
        this.aflyService = aflyService;
    }

    @RequestMapping("/dynamic-datasource-test")
    public void dynamicDataSourceTest(){
        aflyService.dynamicDataSourceTest();
    }
}
