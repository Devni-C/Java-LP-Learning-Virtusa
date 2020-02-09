package com.devni.tlp.employeeservice.model;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String name;
    private int marks;

    public Employee() {

    }

    public Employee(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public static List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Devni", 85));
        employees.add(new Employee("Manuri", 98));
        employees.add(new Employee("Pasan", 45));
        employees.add(new Employee("Nipun", 73));
        employees.add(new Employee("Randi", 66));

        return employees;
    }
}
