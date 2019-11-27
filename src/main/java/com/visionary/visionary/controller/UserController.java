package com.visionary.visionary.controller;

import com.visionary.visionary.mapper.UserMapper;
import com.visionary.visionary.model.Credentials;
import com.visionary.visionary.model.PrivateUserProfileDto;
import com.visionary.visionary.model.SignUpDto;
import com.visionary.visionary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.support.HttpAccessor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper, AuthenticationManager authenticationManager) {
        this.userMapper = userMapper;
        this.userService = userService;
    }



    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/private/user-profile")
    public void updateUser(PrivateUserProfileDto privateUserProfileDto) {
        userService.updateUser(userMapper.toUser(privateUserProfileDto));
    }


    @ResponseStatus(HttpStatus.ACCEPTED)
    @PatchMapping("/{userId}/verify")
    public void verifyUser(@PathVariable("userId") UUID id, Boolean verified) {
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
