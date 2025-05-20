package com.projectmanager.projectmanager.dto;

import com.projectmanager.projectmanager.model.User;
import lombok.Getter;

@Getter
public class UserResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String rol;

    public UserResponseDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.rol = user.getRole().getRol();
    }
}
