package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;

public class ConfigMap {

    @Value("${appConfig.default-page-size}")

    public static int pageSize;
    @Value("${appConfig.default-page-number}")
    public  static int pageNumber;
}
