package com.dorm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@MapperScan("com.dorm")
@EnableJpaRepositories(basePackages = "com.dorm.dao")
@EntityScan("com.dorm.entity")
public class MainApplication extends SpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

}
