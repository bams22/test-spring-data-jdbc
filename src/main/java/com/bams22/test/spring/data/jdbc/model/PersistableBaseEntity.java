package com.bams22.test.spring.data.jdbc.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;

import java.util.UUID;

@Data
public abstract class PersistableBaseEntity implements Persistable<UUID> {

    @Id
    @Column("id")
    private UUID id;

    @Transient
    @Setter(AccessLevel.PRIVATE)
    private boolean isNew = true;

    public PersistableBaseEntity() {
    }

    public PersistableBaseEntity(UUID id) {
        this.id = id;
    }
}
