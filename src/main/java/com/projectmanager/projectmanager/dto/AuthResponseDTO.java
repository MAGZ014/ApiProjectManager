package com.projectmanager.projectmanager.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResponseDTO {

    private String token;
    private String name;
    private String role;

    public AuthResponseDTO(String token, String name, String role) {
        this.token = token;
        this.name = name;
        this.role = role;
    }
}
