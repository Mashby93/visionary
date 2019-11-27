package com.visionary.visionary.domain;

import com.visionary.visionary.config.security.Roles;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import java.nio.file.attribute.UserPrincipal;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.TimeZone;

@Entity
public class User extends Identifiable {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;
    private Double averageReview;
    private Boolean verified;
    private Boolean locked;
    private Date lastLogin;
    private Boolean banned;
    private Date banExpiration;
    private Roles roles;

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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getAverageReview() {
        return averageReview;
    }

    public void setAverageReview(Double averageReview) {
        this.averageReview = averageReview;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Boolean getBanned() {
        return banned;
    }

    public void setBanned(Boolean banned) {
        this.banned = banned;
    }

    public Date getBanExpiration() {
        return banExpiration;
    }

    public void setBanExpiration(Date banExpiration) {
        this.banExpiration = banExpiration;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }
}
