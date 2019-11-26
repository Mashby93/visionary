package com.visionary.visionary.domain;

import org.springframework.data.annotation.CreatedBy;

import javax.persistence.*;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;

@MappedSuperclass
public abstract class Auditable extends Identifiable {
    @Column(name = "created_by")
    private UUID createdBy;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = Date.from(Instant.now());

    public UUID getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UUID createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
