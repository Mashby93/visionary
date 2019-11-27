package com.visionary.visionary.controller;

import com.visionary.visionary.model.Credentials;
import com.visionary.visionary.model.SignUpDto;
import com.visionary.visionary.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private UserService userService;
    private AuthenticationManager authenticationManager;

    public AuthenticationController(UserService userService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/login")
    public String login(@RequestBody @Valid Credentials credentials) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(credentials.getUserName(), credentials.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(auth);
        return "";
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/signUp")
    public void signUp(@RequestBody @Valid SignUpDto signUpDto) {
        userService.signUp(signUpDto);
    }
}
