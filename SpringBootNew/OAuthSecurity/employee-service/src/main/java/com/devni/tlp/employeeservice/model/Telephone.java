package com.devni.tlp.employeeservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Telephone {

    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String number;

    @ManyToOne
            @JoinColumn
            @JsonIgnore
    Employee employee;

    public Telephone() {
    }

    public Telephone(String number, Employee employee) {
        this.number = number;
        this.employee = employee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
