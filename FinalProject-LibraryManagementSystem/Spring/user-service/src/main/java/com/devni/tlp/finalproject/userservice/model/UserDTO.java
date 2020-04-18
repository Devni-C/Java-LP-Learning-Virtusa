package com.devni.tlp.finalproject.userservice.model;

import lombok.Data;

import java.time.Instant;

@Data
public class UserDTO {
    private String username;
    private String password;
    private String name;
    private String email;
    private String mobile;
    private boolean isActive;
    private boolean isDeleted;
    private Instant createdAt;
    private Instant updatedAt;
}
