package com.devni.tlp.employeeservice.service;

import com.devni.tlp.employeeservice.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAllEmployee();

    Employee saveEmployee(Employee employee);

    Employee getEmployeeById(int id);

    public Employee fetchEmployee(int id);
}
