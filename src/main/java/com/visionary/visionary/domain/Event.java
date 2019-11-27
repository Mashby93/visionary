package com.visionary.visionary.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
public class Event extends Auditable{
    private String title;
    private String description;
    @OneToOne
    @JoinColumn(name = "category_id")
    private Category categoryId;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start_time")
    private Date startTime;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_time")
    private Date endTime;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    private Long savedCount;
    @Embedded
    private Location location;
    private Boolean cancelled = false;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    public Boolean getCancelled() {
        return cancelled;
    }

    public void setCancelled(Boolean cancelled) {
        this.cancelled = cancelled;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getSavedCount() {
        return savedCount;
    }

    public void setSavedCount(Long savedCount) {
        this.savedCount = savedCount;
    }
}
