package com.devni.tlp.finalproject.userservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String username;
    private String mobile;
    private String email;
    private boolean isActive;
    private boolean isDeleted;
    private Instant createdAt;
    private Instant updatedAt;

    @JsonIgnore
    private String password;
}
