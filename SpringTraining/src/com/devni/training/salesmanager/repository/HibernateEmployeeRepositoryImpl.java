package com.devni.training.salesmanager.repository;

import com.devni.training.salesmanager.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class HibernateEmployeeRepositoryImpl implements EmployeeRepository {
    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();

        Employee employee = new Employee();
        employee.setEmployeeName("Devni");
        employee.setEmployeeLocation("Panadura");
        employees.add(employee);
        return employees;
    }
}
