package com.bams22.test.spring.data.jdbc.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Data
@Table("users")
public class User extends PersistableBaseEntity {

    @Column("name")
    private String name;

    @LastModifiedDate
    @Column(value = "updated_at")
    private Instant updatedAt;
}
