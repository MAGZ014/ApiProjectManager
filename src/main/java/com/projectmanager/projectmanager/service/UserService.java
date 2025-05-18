package com.projectmanager.projectmanager.service;

import com.projectmanager.projectmanager.model.User;
import com.projectmanager.projectmanager.respository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public User updateUser(Long id,User data){
        User user =userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setName(data.getName());
        user.setEmail(data.getEmail());
        user.setPhone(data.getPhone());
        user.setPassword(data.getPassword());
        user.setRole(data.getRole());

        return userRepository.save(user);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
