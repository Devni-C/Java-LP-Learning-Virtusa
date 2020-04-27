package com.devni.tlp.finalproject.userservice.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.Set;

@Data //SignupRequest
public class UserDTO {

    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    private Set<String> role;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

//    @NotBlank
//    @Size(min = 2)
    private String name;

//    @NotBlank
//    @Size(max = 10, min = 0)
    private String mobile;

    private boolean isActive;
    private boolean isDeleted;
    private Instant createdAt;
    private Instant updatedAt;

    public Set<String> getRole() {
        return this.role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }
}
