package com.projectmanager.projectmanager.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResponseDTO {

    private String token;
    private String refreshToken;
    private String name;
    private String email;
    private String role;

    public AuthResponseDTO(String token, String refreshToken, String name, String email, String role) {
        this.token = token;
        this.refreshToken = refreshToken;
        this.name = name;
        this.email = email;
        this.role = role;
    }
}
