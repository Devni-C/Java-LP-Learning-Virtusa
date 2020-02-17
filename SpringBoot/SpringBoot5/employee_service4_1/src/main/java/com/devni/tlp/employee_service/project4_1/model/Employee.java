package com.devni.tlp.employee_service.project4_1.model;

import com.devni.tlp.employee_service.project4_1.shared_model.Allocation;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer marks;

    @OneToOne(cascade = CascadeType.ALL)
    Address address;

    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
    List<Telephone> telephones;

    //    @ManyToMany(fetch = FetchType.EAGER)
    @ManyToMany(cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinTable(
        joinColumns = {@JoinColumn(name = "eid", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "pid", referencedColumnName = "id")}
    )
    List<Project> projects;

    @Transient
    Allocation[] allocations;

    public Employee() {

    }

    /*{
    "id": 14,
    "name": "Devni",
    "marks": 65,
    "address": {
        "id": 14,
        "city": "Kaluthara"
    },
    "telephones": [
        {
            "id": 5,
            "tpNo": "0711234567"
        },
        {
            "id": 6,
            "tpNo": "0728964578"
        }
    ],
    "projects": [
        {
            "id": 27,
            "name": "BT",
            "employees": null
        },
        {
            "id": 28,
            "name": "VC",
            "employees": null
        }
    ]
}*/
}
