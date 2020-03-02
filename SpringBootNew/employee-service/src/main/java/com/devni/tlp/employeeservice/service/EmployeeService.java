package com.devni.tlp.employeeservice.service;

import com.devni.tlp.employeeservice.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee test();

    Employee save(Employee employee);

    Employee fetchEmployeeById(int id);

    List<Employee> fetchAllEmployees();
}
