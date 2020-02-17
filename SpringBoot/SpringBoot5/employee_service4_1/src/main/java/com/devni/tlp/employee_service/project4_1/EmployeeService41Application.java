package com.devni.tlp.employee_service.project4_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EmployeeService41Application {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeService41Application.class, args);
    }

}
