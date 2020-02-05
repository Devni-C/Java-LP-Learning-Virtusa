package com.devni.training.salesmanager.service;

import com.devni.training.salesmanager.model.Employee;
import com.devni.training.salesmanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
    //EmployeeRepository employeeRepository = new HibernateEmployeeRepositoryImpl();
    //private EmployeeRepository employeeRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    public EmployeeServiceImpl() {
        System.out.println("Default constructor executed");

    }

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        System.out.println("Overloaded constructor executed");
        this.employeeRepository = employeeRepository;
    }

    public EmployeeRepository getEmployeeRepository() {
        return employeeRepository;
    }

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        System.out.println("Setter Injection fired");
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }
}
