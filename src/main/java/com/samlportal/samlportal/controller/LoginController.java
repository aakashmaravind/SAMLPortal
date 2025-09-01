package com.samlportal.samlportal.controller;


import com.samlportal.samlportal.model.Users;
import com.samlportal.samlportal.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private JavaMailSender mailSender;

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(
            @RequestParam String name,
            @RequestParam String password,
            @RequestParam String role) {
        Optional<Users> user = usersRepository.findByNameAndPasswordAndRole(name, password, role);
        Map<String, Object> response = new HashMap<>();

        if (user.isPresent()) {
            response.put("status", "success");
            response.put("message", "Login successful");
            response.put("user", user.get());
            return ResponseEntity.ok(response);
        } else {
            response.put("status", "error");
            response.put("message", "Invalid username, password, or role");
            return ResponseEntity.status(401).body(response);
        }
    }

}
