package com.visionary.visionary.controller;

import com.visionary.visionary.mapper.UserMapper;
import com.visionary.visionary.model.PrivateUserProfileDto;
import com.visionary.visionary.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userMapper = userMapper;
        this.userService = userService;
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/private")
    public void updateUser(PrivateUserProfileDto privateUserProfileDto) {
        userService.updateUser(userMapper.toUser(privateUserProfileDto));
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PatchMapping("/{userId}/verify")
    public void verifyUser(@PathVariable("userId") String id, Boolean verified) {
        userService.updateVerification(id,verified);
    }

   /* @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{userId}/private/profile")
    public PrivateUserProfileDto getPrivateProfile(@PathVariable("userId") String userId) {
        userService.getById()
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{userId}/public/profile")*/
}
