package com.visionary.visionary.controller;

import com.visionary.visionary.controller.filter.ReportFilters;
import com.visionary.visionary.controller.pagination.Pagination;
import com.visionary.visionary.controller.param.ReportReason;
import com.visionary.visionary.domain.Report;
import com.visionary.visionary.service.ManagementConsoleService;
import com.visionary.visionary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/management-console")
public class ManagementConsoleController {

    private ManagementConsoleService managementConsoleService;

    @Autowired
    public ManagementConsoleController(ManagementConsoleService managementConsoleService) {
        this.managementConsoleService = managementConsoleService;
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/reports")
    public Page<Report> getReports(ReportFilters filters, Pagination pagination) {
        return managementConsoleService.getReports(filters, pagination.convert());
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/users/{userId}/ban")
    public void banUser(@PathVariable("userId") UUID id,  @RequestBody ReportReason reportReason){
        managementConsoleService.banUser(id, reportReason);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/users/{userId}/un-ban")
    public void unBanUser(UUID id) {
        managementConsoleService.unBanUser(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/users/{userId}/verify")
    public void verifyUser(UUID id) {
        managementConsoleService.verifyUserAccount(id);
    }

}
