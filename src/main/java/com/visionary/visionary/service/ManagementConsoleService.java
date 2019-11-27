package com.visionary.visionary.service;

import com.visionary.visionary.controller.error.InsufficientAccountPriviledgeException;
import com.visionary.visionary.controller.filter.ReportFilters;
import com.visionary.visionary.controller.param.ReportReason;
import com.visionary.visionary.domain.Report;
import com.visionary.visionary.domain.User;
import com.visionary.visionary.util.SecurityUtil;
import com.visionary.visionary.util.ValidationUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ManagementConsoleService {
    private UserService userService;

    public ManagementConsoleService(UserService userService) {
        this.userService = userService;
    }

    public void banUser(UUID id, ReportReason reportReason) {
        User user = userService.getById(id);
        ValidationUtil.assertTrue(SecurityUtil.currentUserHasHigherAuthority(user),
                new InsufficientAccountPriviledgeException());
    }

    public void unBanUser(UUID id) {
        User user = userService.getById(id);
        ValidationUtil.assertTrue(SecurityUtil.currentUserHasHigherAuthority(user),
                new InsufficientAccountPriviledgeException());
    }

    public void verifyUserAccount(UUID id) {
        User user = userService.getById(id);
        user.setVerified(true);
        userService.updateUser(user);
    }

    public Page<Report> getReports(ReportFilters filters,Pageable pageable) {
        return Page.empty();
    }

}
