package com.graduation.healthservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
@MapperScan("com.graduation.healthservice.mapper")
public class HealthserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealthserviceApplication.class, args);
    }

}
