package com.devni.tlp.employeeservice.service;

import com.devni.tlp.employeeservice.model.Employee;
import com.devni.tlp.employeeservice.repository.EmployeeRepository;
import com.devni.tlp.employeeservice.shared_model.Allocation;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    RestTemplate restTemplate;

    @Bean
    RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    HttpHeaders httpHeaders = new HttpHeaders();
    HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);

    @Override
    public Employee fetchEmployee(int id) {
//        System.out.println(id);
        Optional<Employee> optional = employeeRepository.findById(id);
        if(optional.isPresent()){

            Employee employee = optional.get();

            ResponseEntity<Allocation[]> responseEntity = restTemplate.exchange("http://localhost:8181/allocation_service/empid/"+id, HttpMethod.GET, httpEntity, Allocation[].class);

            employee.setAllocations(responseEntity.getBody());
//            System.out.println(employee.getName());
            return employee;
        }
        return null;



    }

    @Override
    public List<Employee> findAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.orElse(null); //if-> employee,else-> null
    }
}
