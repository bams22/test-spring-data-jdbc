package com.bams22.test.spring.data.jdbc.repo;

import com.bams22.test.spring.data.jdbc.model.User;
import org.springframework.data.repository.ListCrudRepository;

import java.util.UUID;

public interface UserRepo extends ListCrudRepository<User, UUID> {
}
