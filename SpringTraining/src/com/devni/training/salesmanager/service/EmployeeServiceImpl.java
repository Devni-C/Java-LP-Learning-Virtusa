package com.devni.training.salesmanager.service;

import com.devni.training.salesmanager.model.Employee;
import com.devni.training.salesmanager.repository.EmployeeRepository;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    //EmployeeRepository employeeRepository = new HibernateEmployeeRepositoryImpl();
    //private EmployeeRepository employeeRepository;
    EmployeeRepository employeeRepository;

    //You must have no arg constructor when defining autowiring byType or ByName
    /*public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }*/

    public EmployeeRepository getEmployeeRepository() {
        return employeeRepository;
    }

    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }
}
