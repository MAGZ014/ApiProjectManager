package com.projectmanager.projectmanager.dto;

import com.projectmanager.projectmanager.model.User;

public class UserResponseDTO {
    public Long id;
    public String name;
    public String email;
    public String phone;
    public String rol;

    public UserResponseDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.rol = user.getRole().getRol();
    }
}
