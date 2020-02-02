package com.devni.training.salesmanager.repository;

import com.devni.training.salesmanager.model.Employee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> getAllEmployees();
}
