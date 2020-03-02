package com.devni.tlp.employeeservice.repository;

import com.devni.tlp.employeeservice.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
