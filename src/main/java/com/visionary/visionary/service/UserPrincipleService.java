package com.visionary.visionary.service;

import com.visionary.visionary.model.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserPrincipleService implements UserDetailsService {
    private UserService userService;

    @Autowired
    public UserPrincipleService(UserService userService) {
        this.userService = userService;
    }

    public UserPrincipal loadUserByUsername(String username) {
        return UserPrincipal.fromUser(userService.loadByUserName(username));
    }

    public UserPrincipal loadByUserId(UUID id) {
        return UserPrincipal.fromUser(userService.getById(id));
    }
}
