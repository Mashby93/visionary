package com.visionary.visionary.model;

public class PrivateUserProfileDto extends PublicUserProfileDto {
    private Credentials credentials;

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }
}
