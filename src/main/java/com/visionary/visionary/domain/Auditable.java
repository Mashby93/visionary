package com.visionary.visionary.domain;

import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;

@MappedSuperclass
public abstract class Auditable extends Identifiable {
    private User createdBy;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = Date.from(Instant.now());

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
