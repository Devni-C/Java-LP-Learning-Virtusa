package com.devni.tlp.employee_service.project4_1.repository;

import com.devni.tlp.employee_service.project4_1.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
