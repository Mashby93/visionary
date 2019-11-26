package com.visionary.visionary.controller.filter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class EventFilter implements Filters{
    private List<UUID> categoryIdList;
    private List<UUID> userIdList;
    private Date startDate;
    private Date endDate;
    private Double minimumPosterRating;
    private Boolean verifiedUsers;
    private Boolean cancelled;

    public List<UUID> getCategoryIdList() {
        return categoryIdList;
    }

    public void setCategoryIdList(List<UUID> categoryIdList) {
        this.categoryIdList = categoryIdList;
    }

    public List<UUID> getUserIdList() {
        return userIdList;
    }

    public void setUserIdList(List<UUID> userIdList) {
        this.userIdList = userIdList;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Double getMinimumPosterRating() {
        return minimumPosterRating;
    }

    public void setMinimumPosterRating(Double minimumPosterRating) {
        this.minimumPosterRating = minimumPosterRating;
    }

    public Boolean getVerifiedUsers() {
        return verifiedUsers;
    }

    public void setVerifiedUsers(Boolean verifiedUsers) {
        this.verifiedUsers = verifiedUsers;
    }

    public Boolean getCancelled() {
        return cancelled;
    }

    public void setCancelled(Boolean cancelled) {
        this.cancelled = cancelled;
    }
}
