package com.devsuperior.dslist.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.UserDTO;
import com.devsuperior.dslist.entities.User;
import com.devsuperior.dslist.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Transactional(readOnly = true)
    public UserDTO findByEmail(String email) {
        Optional<User> result = userRepository.findByEmail(email);
        User user = result.orElseThrow(() -> new RuntimeException("User not found"));
        return new UserDTO(user);
    }
    
    @Transactional(readOnly = true)
    public UserDTO login(String email, String password) {
        Optional<User> result = userRepository.findByEmail(email);
        User user = result.orElseThrow(() -> new RuntimeException("User not found"));
        
        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid password");
        }
        
        return new UserDTO(user);
    }

    @Transactional
    public UserDTO register(String email, String name, String password) {
        User newUser = new User();
        newUser.setEmail(email);
        newUser.setName(name);
        newUser.setPassword(password);
        
        userRepository.save(newUser);
        
        return new UserDTO(newUser);
    }
}
