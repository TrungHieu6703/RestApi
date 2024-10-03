package com.example.Users3.controller;

import com.example.Users3.dto.UserCreationRequest;
import com.example.Users3.dto.UserUpdateRequest;
import com.example.Users3.entity.User;
import com.example.Users3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/users")
    User createUser(@RequestBody UserCreationRequest request) {
       return userService.createUser(request);
    }

    @GetMapping("/users")
    List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping("user/{id}")
    void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }

    @GetMapping("user/{id}")
    User getUser(@PathVariable String id) {
       return userService.getUser(id);
    }

    @PutMapping("user/{id}")
    User updateUser(@PathVariable String id, @RequestBody UserUpdateRequest request) {
        return userService.UpdateUser(request, id);
    }
}
