package com.devni.tlp.employeeservice.controller;

import com.devni.tlp.employeeservice.model.Address;
import com.devni.tlp.employeeservice.model.Employee;
import com.devni.tlp.employeeservice.model.Project;
import com.devni.tlp.employeeservice.model.Telephone;
import com.devni.tlp.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/services")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Employee saveEmployee (@RequestBody Employee employee) {

        for(Telephone telephone: employee.getTelephones()){
            telephone.setEmployee(employee);
        }

        return employeeService.saveEmployee(employee);
    }

    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public List<Employee> fetchAllEmployee() {
        return employeeService.findAllEmployee();
    }

    @RequestMapping(value = "/byid/{id}")
    public Employee findEmpById(@PathVariable Integer id) {
        return employeeService.fetchEmployee(id);
    }

    @RequestMapping("/hello")
    public String greeting() {
        return "<h1>Hello Devni</h1>";
    }


    @RequestMapping(value = "/test")
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

        List<Project> projects = new ArrayList<>();
        Project project = new Project();
        project.setId(11);
        project.setName("mko");

        Project project2 = new Project();
        project2.setId(12);
        project2.setName("acd");

        projects.add(project);
        projects.add(project2);

        Employee employee = new Employee();
        employee.setName("Test");
        employee.setMarks(100);
        employee.setId(10);
        employee.setAddress(address);
        employee.setTelephones(telephones);

        return employee;
    }
}
