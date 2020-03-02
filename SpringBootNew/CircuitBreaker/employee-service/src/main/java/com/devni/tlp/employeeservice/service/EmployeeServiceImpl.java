package com.devni.tlp.employeeservice.service;

import com.devni.tlp.employeeservice.model.Address;
import com.devni.tlp.employeeservice.model.Employee;
import com.devni.tlp.employeeservice.model.Telephone;
import com.devni.tlp.employeeservice.repository.EmployeeRepository;
import com.devni.tlp.employeeservice.shared_model.Allocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Bean
    @LoadBalanced
    RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    HttpHeaders httpHeaders = new HttpHeaders();
    HttpEntity<String> httpEntity = new HttpEntity<>("", httpHeaders);

    @Override
    public Employee test() {
        Address address = new Address("test city");
        Employee employee = new Employee("testEmp", address, null, null);
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        for(Telephone telephone : employee.getTelephones()) {
            telephone.setEmployee(employee);
        }
        return employeeRepository.save(employee);
    }

    @Override
    public Employee fetchEmployeeById(int id) {
        Optional<Employee> optional = employeeRepository.findById(id);
        if(optional.isPresent()) {
            Employee employee = optional.get();
            ResponseEntity<Allocation[]> responseEntity = restTemplate.exchange(
                    "http://localhost:9191/alloservice/fetchEmp" + id, HttpMethod.POST, httpEntity, Allocation[].class
            );
            employee.setAllocations(responseEntity.getBody());

            return employee;
        }
        return null;
    }

    @Override
    public List<Employee> fetchAllEmployees() {
        return employeeRepository.findAll();
    }
}
