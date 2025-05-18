package com.projectmanager.projectmanager.controller;

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
    public List<User> userList() {
        return userService.getAllUser();
    }


    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
