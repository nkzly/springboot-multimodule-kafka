package com.cloudmore.task.api.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class EnvironmentConfig {
    public static String kafkaUrl;
    public static String taxRate;

    @Value("${kafka.url}")
    public void setKafkaUrl(String kafkaUrl) {
        EnvironmentConfig.kafkaUrl = kafkaUrl;
    }

    @Value("${employee.tax}")
    public void setTaxRate(String taxRate) {
        EnvironmentConfig.taxRate = taxRate;
    }
}
