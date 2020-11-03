package com.visionary.visionary.domain;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractAuditEntity extends AbstractEntity {
    private Long createdAt;
    private Long updatedAt;

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }
}
