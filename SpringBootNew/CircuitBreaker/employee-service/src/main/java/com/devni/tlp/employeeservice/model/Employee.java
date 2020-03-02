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
    Integer id;

    String name;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Address address;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Telephone> telephones;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
            @JoinTable(
                    joinColumns = {@JoinColumn(name = "eid", referencedColumnName = "id")},
                    inverseJoinColumns = {@JoinColumn(name = "pid", referencedColumnName = "id")}
            )
            @Fetch(FetchMode.SUBSELECT)
    List<Project> projects;

    @Transient
    Allocation[] allocations;

    public Employee(){

    }

    public Employee(String name, Address address, List<Telephone> telephones, List<Project> projects) {
        this.name = name;
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
}
