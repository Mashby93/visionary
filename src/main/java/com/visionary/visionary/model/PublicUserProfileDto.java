package com.visionary.visionary.model;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class PublicUserProfileDto {
    private UUID id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    private Boolean verified = false;
    private Double averageUserReview = 0.0;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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
