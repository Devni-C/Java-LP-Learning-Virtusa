package com.devni.tlp.employee_service.project3.controller;

import com.devni.tlp.employee_service.project3.model.Address;
import com.devni.tlp.employee_service.project3.model.Employee;
import com.devni.tlp.employee_service.project3.model.Telephone;
import com.devni.tlp.employee_service.project3.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/services")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/emp/{id}")
    public Employee findById(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }

    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    public List<Employee> getAllEmployees() {
        return employeeService.findAllEmployee();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Employee saveEmployee (@RequestBody Employee employee) {

        for(Telephone telephone: employee.getTelephones()){
            telephone.setEmployee(employee);
        }

        System.out.println(employee.getId());
        return employeeService.saveEmployee(employee);
    }

    @RequestMapping("/hello")
    public String greeting() {
        return "<h1>Hello Devni</h1>";
    }

    @RequestMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee test() {

        Address address = new Address();
        address.setId(45);
        address.setCity("Kandy");

        List<Telephone> telephones = new ArrayList<>();

        Telephone telephone= new Telephone();
        telephone.setId(54);
        telephone.setTpNo("0112554422");

        Telephone telephone2= new Telephone();
        telephone2.setId(542);
        telephone2.setTpNo("0112535315");

        telephones.add(telephone);
        telephones.add(telephone2);

        Employee employee = new Employee();
        employee.setName("Test");
        employee.setMarks(100);
        employee.setId(10);
        employee.setAddress(address);
        employee.setTelephones(telephones);

        return employee;
    }
}
