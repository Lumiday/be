package com.lumiday.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;

@ConfigurationPropertiesScan
@ComponentScan(basePackages = {"com.lumiday.springboot", "com.lumiday.jpa"})
@SpringBootApplication
public class CoreApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoreApiApplication.class, args);
    }
}
