package com.devni.tlp.employee_service.project3.service;

import com.devni.tlp.employee_service.project3.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAllEmployee();

    Employee saveEmployee(Employee employee);

    Employee getEmployeeById(int id);
}
