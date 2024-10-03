package com.example.Users3.service;

import com.example.Users3.dto.UserCreationRequest;
import com.example.Users3.dto.UserUpdateRequest;
import com.example.Users3.entity.User;
import com.example.Users3.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(UserCreationRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    public User getUser(String id) {
       return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    public User UpdateUser(UserUpdateRequest request, String id) {
        User user = getUser(id);

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());
        user.setPassword(request.getPassword());
        return userRepository.save(user);
    }
}
