package com.devni.tlp.employeeservice.model;

import com.devni.tlp.employeeservice.shared_model.Allocation;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer marks;

    @OneToOne(cascade = CascadeType.ALL)
    Address address;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Telephone> telephones;

//    @ManyToMany(fetch = FetchType.EAGER)
    @ManyToMany(cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SELECT)
    @JoinTable(
        joinColumns = {@JoinColumn(name = "eid", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "pid", referencedColumnName = "id")}
    )
    List<Project> projects;

    @Transient
    Allocation[] allocations;

    public Employee() {

    }

    public Employee(Integer id, String name, Integer marks, Address address, List<Telephone> telephones, List<Project> projects) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        this.address = address;
        this.telephones = telephones;
        this.projects = projects;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMarks() {
        return marks;
    }

    public void setMarks(Integer marks) {
        this.marks = marks;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Telephone> getTelephones() {
        return telephones;
    }

    public void setTelephones(List<Telephone> telephones) {
        this.telephones = telephones;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Allocation[] getAllocations() {
        return allocations;
    }

    public void setAllocations(Allocation[] allocations) {
        this.allocations = allocations;
    }

    /*public static List<Employee> getAllEmployees() {
//    @JsonIgnore
//    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1,"Devni", 76));
        employees.add(new Employee(2,"Amaya", 98));
        employees.add(new Employee(3,"Ranidu", 55));
        employees.add(new Employee(4,"Pasan", 34));
        employees.add(new Employee(5,"Yasas", 88));

        return employees;
    }*/
}
