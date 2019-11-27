package com.visionary.visionary.service;

import com.visionary.visionary.controller.error.AlreadyExistsException;
import com.visionary.visionary.controller.error.NotEqualException;
import com.visionary.visionary.domain.User;
import com.visionary.visionary.model.SignUpDto;
import com.visionary.visionary.model.UserPrincipal;
import com.visionary.visionary.repository.UserRepository;
import com.visionary.visionary.service.error.NotFoundException;
import com.visionary.visionary.util.ValidationUtil;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserPrincipal getCurrentUser() {
        return (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public void updateUser(User user) {
        ValidationUtil.assertNoVulgarity(user.getFirstName());
        ValidationUtil.assertNoVulgarity(user.getLastName());
        ValidationUtil.assertValidEmail(user.getEmailAddress());
        userRepository.save(user);
    }

    public User getById(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException());

    }

    public User loadByUserName(String username) {
        return userRepository.findByEmailAddress(username)
                .orElseThrow(() -> new NotFoundException());
    }

    public User signUp(SignUpDto signUpDto) {
        ValidationUtil.assertEquals(signUpDto.getCredentials().getPassword(),
                signUpDto.getRepeatPassword(), new NotEqualException("Password Fields Do Not Match"));
        ValidationUtil.assertValidEmail(signUpDto.getCredentials().getUserName());
        ValidationUtil.assertTrue(userRepository.existsByEmailAddress(signUpDto.getCredentials().getUserName()),
                new AlreadyExistsException("User already exists with email address"));
        ValidationUtil.assertNoVulgarity(signUpDto.getFirstName());
        ValidationUtil.assertNoVulgarity(signUpDto.getLastName());
       User user = new User();
       user.setEmailAddress(signUpDto.getCredentials().getUserName());
       user.setFirstName(signUpDto.getFirstName());
       user.setLastName(signUpDto.getLastName());
       return userRepository.save(user);
    }


    public User updateVerification(UUID id, Boolean valid) {
        User user = getById(id);
        user.setVerified(valid);
        return userRepository.save(user);
    }

}
