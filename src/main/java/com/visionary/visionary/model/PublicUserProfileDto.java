package com.visionary.visionary.model;

public class PublicUserProfileDto {
    private String id;
    private String firstName;
    private String lastName;
    private Boolean verified;
    private Double averageUserReview;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public Double getAverageUserReview() {
        return averageUserReview;
    }

    public void setAverageUserReview(Double averageUserReview) {
        this.averageUserReview = averageUserReview;
    }
}
