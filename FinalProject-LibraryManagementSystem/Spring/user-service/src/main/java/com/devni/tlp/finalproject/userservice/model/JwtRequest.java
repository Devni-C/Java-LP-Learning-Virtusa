package com.devni.tlp.finalproject.userservice.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data // LoginRequest
public class JwtRequest { // implements Serializable {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

}
