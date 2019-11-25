package com.visionary.visionary.service;

import com.visionary.visionary.domain.User;
import org.springframework.stereotype.Service;

@Service
public class PermissionService {
    private final UserService userService;

    public PermissionService(UserService userService) {
        this.userService = userService;
    }

    public boolean canAccess() {
        return true;
    }

}
