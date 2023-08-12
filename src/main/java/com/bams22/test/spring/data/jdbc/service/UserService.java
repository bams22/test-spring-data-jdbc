package com.bams22.test.spring.data.jdbc.service;

import com.bams22.test.spring.data.jdbc.model.User;
import com.bams22.test.spring.data.jdbc.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepo userRepo;

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(UUID.randomUUID());
        }
        return userRepo.save(user);
    }

    public Optional<User> findUserById(UUID id) {
        return userRepo.findById(id);
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }
}
