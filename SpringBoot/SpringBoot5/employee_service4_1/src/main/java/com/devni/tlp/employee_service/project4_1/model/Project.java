package com.devni.tlp.employee_service.project4_1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToMany(mappedBy = "projects", fetch = FetchType.EAGER)
    @JsonIgnore
    List<Employee> employees;
}

