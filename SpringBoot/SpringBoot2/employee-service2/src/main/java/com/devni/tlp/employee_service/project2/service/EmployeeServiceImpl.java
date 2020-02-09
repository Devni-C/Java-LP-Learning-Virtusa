package com.devni.tlp.employee_service.project2.service;

import com.devni.tlp.employee_service.project2.model.Employee;
import com.devni.tlp.employee_service.project2.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }
}
