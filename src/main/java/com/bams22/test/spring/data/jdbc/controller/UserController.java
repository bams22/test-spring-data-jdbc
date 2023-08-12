package com.bams22.test.spring.data.jdbc.controller;

import com.bams22.test.spring.data.jdbc.model.User;
import com.bams22.test.spring.data.jdbc.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/{id}")
    public User find(@PathVariable UUID id) {
        final var result = userService.findUserById(id)
                .orElse(null);
        return result;
    }

    @GetMapping()
    public List<User> findAll() {
        return userService.findAll();
    }
}
