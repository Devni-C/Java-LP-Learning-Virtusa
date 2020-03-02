package com.devni.tlp.employeeservice.controller;

import com.devni.tlp.employeeservice.model.Employee;
import com.devni.tlp.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empservice")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/test")
    public Employee test() {
        return employeeService.test();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Employee save(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @RequestMapping("/employee/{id}")
    public Employee fetchEmployee(@PathVariable int id) {
        return employeeService.fetchEmployeeById(id);
    }

    @RequestMapping("/allemployees")
    public List<Employee> fetchAllEmployees() {
        return employeeService.fetchAllEmployees();
    }
}
