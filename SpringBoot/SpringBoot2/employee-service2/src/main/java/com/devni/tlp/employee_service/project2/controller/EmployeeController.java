package com.devni.tlp.employee_service.project2.controller;

import com.devni.tlp.employee_service.project2.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
public class EmployeeController {

    @RequestMapping(value = "/employees") //, produces = MediaType.APPLICATION_XML_VALUE)
    public List<Employee> getAllEmployees() {
        return Employee.getAllEmployees();
    }



}
