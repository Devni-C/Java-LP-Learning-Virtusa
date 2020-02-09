package com.devni.tlp.employee_service.project2.model;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    int id;
    String name;
    String address;

    public Employee() {
    }

    public Employee(String nkjn) {
        this.name = nkjn;
    }

    public Employee(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static List<Employee> getAllEmployees(){
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(01, "Devni", "Panadura"));
        employees.add(new Employee(02, "Randini", "Rajagiriya"));
        employees.add(new Employee(03, "Kasun", "Kandy"));
        employees.add(new Employee(04, "Manuri", "Rathmalana"));
        employees.add(new Employee(05, "Pasindu", "Wadduwa"));

        return employees;
    }
}
