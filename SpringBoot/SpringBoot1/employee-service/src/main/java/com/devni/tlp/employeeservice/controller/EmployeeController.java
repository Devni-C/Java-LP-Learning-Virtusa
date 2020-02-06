package com.devni.tlp.employeeservice.controller;

import com.devni.tlp.employeeservice.model.Employee;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/services")
public class EmployeeController {
    @RequestMapping("/hello")
    public String greeting() {
        return "Hello from SpringBoot :D";
    }

    @RequestMapping(value = "/employees", produces = MediaType.APPLICATION_ATOM_XML_VALUE)
    public List<Employee> getAllEmployees() {
        return Employee.getAllEmployees();
    }
}
