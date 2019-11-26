package com.visionary.visionary.domain;

import com.fasterxml.uuid.Generators;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@MappedSuperclass
public abstract class Identifiable {
    @Id
    @Column(nullable = false, unique = true, updatable = false, columnDefinition="CHAR(36)")
    private UUID id = Generators.timeBasedGenerator().generate();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
