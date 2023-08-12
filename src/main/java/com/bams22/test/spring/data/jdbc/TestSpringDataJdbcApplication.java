package com.bams22.test.spring.data.jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@EnableAspectJAutoProxy
@EnableJdbcRepositories("com.bams22.test.spring.data.jdbc.repo")
@EnableJdbcAuditing
@SpringBootApplication
public class TestSpringDataJdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestSpringDataJdbcApplication.class, args);
    }

}
