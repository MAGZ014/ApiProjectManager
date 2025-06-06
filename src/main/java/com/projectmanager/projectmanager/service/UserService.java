package com.projectmanager.projectmanager.service;

import com.projectmanager.projectmanager.dto.UserDTO;
import com.projectmanager.projectmanager.model.User;
import com.projectmanager.projectmanager.model.Rol;
import com.projectmanager.projectmanager.respository.UserRepository;
import com.projectmanager.projectmanager.respository.RolRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RolRepository rolRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, RolRepository rolRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.rolRepository = rolRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with Id: " + id));
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
    }

    public User createUser(UserDTO userDTO){
        Rol rol = rolRepository.findById(userDTO.getRol_id())
                .orElseThrow(()-> new RuntimeException("Rol not found"));
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setRole(rol);

        return userRepository.save(user);
    }

    public User updateUser(Long id,UserDTO userDTO){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Rol rol = rolRepository.findById(userDTO.getRol_id())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setRole(rol);

        return userRepository.save(user);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
