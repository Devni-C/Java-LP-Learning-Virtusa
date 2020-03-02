package com.devni.tlp.allocationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AllocationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AllocationServiceApplication.class, args);
    }

}
