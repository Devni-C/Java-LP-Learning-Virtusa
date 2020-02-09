package com.devni.tlp.employee_service.project2.controller;

import com.devni.tlp.employee_service.project2.model.Employee;
import com.devni.tlp.employee_service.project2.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    /*@RequestMapping(value = "/employee/save", method = RequestMethod.POST)
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }*/

    @PostMapping(path = "/add")
    @ResponseBody
    public String saveEmployee(@RequestParam String name, String city) {
        Employee employee = new Employee();
        employee.setName("Devni");
        employee.setAddress("Panadura");
        employeeRepository.save(employee);

        return "Employee Saved :D";
    }

    @GetMapping(path = "/all")
    @ResponseBody
    public List<Employee> getAllEmployees() {
//        return employeeRepository.findAll();
        return Employee.getAllEmployees();
    }
}
