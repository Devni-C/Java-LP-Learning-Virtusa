package com.devni.training.salesmanager.service;

import com.devni.training.salesmanager.model.Employee;
import com.devni.training.salesmanager.repository.EmployeeRepository;
import com.devni.training.salesmanager.repository.HibernateEmployeeRepositoryImpl;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository employeeRepository = new HibernateEmployeeRepositoryImpl();

    @Override
    public List<Employee> getAllEmplyees() {
        return employeeRepository.getAllEmployees();
    }
}
