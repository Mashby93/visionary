package com.visionary.visionary.model;

import com.visionary.visionary.config.security.Authority;
import com.visionary.visionary.config.security.Roles;
import com.visionary.visionary.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.LinkedList;
import java.util.UUID;

public class UserPrincipal implements UserDetails {
    private UUID id;
    private Collection<GrantedAuthority> authorities;
    private String username;
    private String password;
    private boolean enabled;
    private boolean accountNonExpired;
    private boolean credentialsNonExpired;
    private boolean accountNonLocked;

    public static UserPrincipal fromUser(User user) {
        UserPrincipal principle = new UserPrincipal();
        Collection<GrantedAuthority> authorities = new LinkedList<>();
        for (Roles role : Roles.values()) {
            if (role.compareTo(user.getRoles()) >= 0) {
                authorities.add(new Authority(role));
            }
        }
        principle.setId(user.getId());
        principle.setAccountNonExpired(true);
        principle.setAccountNonLocked(user.getLocked());
        principle.setAuthorities(authorities);
        principle.setUsername(user.getEmailAddress());
        principle.setPassword(user.getPassword());
        principle.setEnabled(true);
        return principle;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }
}
