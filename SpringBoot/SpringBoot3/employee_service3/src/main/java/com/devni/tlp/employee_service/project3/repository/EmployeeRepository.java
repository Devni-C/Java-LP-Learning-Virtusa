package com.devni.tlp.employee_service.project3.repository;

import com.devni.tlp.employee_service.project3.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
