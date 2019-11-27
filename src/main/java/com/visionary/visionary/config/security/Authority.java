package com.visionary.visionary.config.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthoritiesContainer;

public class Authority implements GrantedAuthority {
    private Roles roles;

    public Authority(Roles roles) {
        this.roles = roles;
    }

    public String getAuthority() {
        return roles.name();
    }
}
