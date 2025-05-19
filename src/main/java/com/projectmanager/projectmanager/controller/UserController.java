package com.projectmanager.projectmanager.controller;

import com.projectmanager.projectmanager.dto.UserDTO;
import com.projectmanager.projectmanager.dto.UserResponseDTO;
import com.projectmanager.projectmanager.model.User;
import com.projectmanager.projectmanager.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    public UserController(UserService userService){
        this.userService=userService;

    }

    @GetMapping
    public List<UserResponseDTO> userList() {
        List<User> users = userService.getAllUser();
        return users.stream()
                .map(UserResponseDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public UserResponseDTO getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return new UserResponseDTO(user);
    }

    @GetMapping("/email/{email}")
    public UserResponseDTO getByEmail(@PathVariable String email) {
        User user = userService.getUserByEmail(email);
        return new UserResponseDTO(user);
    }

    @PostMapping
    public UserResponseDTO createUser(@RequestBody UserDTO userDTO) {
        User user = userService.createUser(userDTO);
        return new UserResponseDTO(user);
    }

    @PutMapping("/{id}")
    public UserResponseDTO updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        User user = userService.updateUser(id, userDTO);
        return new UserResponseDTO(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
