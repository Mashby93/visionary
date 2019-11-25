package com.visionary.visionary.service;

import com.visionary.visionary.domain.User;
import com.visionary.visionary.repository.UserRepository;
import com.visionary.visionary.service.error.NotFoundException;
import com.visionary.visionary.util.ValidationUtil;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getCurrentUser() {
        return new User();
    }

    public void updateUser(User user) {
        ValidationUtil.assertNoVulgarity(user.getFirstName());
        ValidationUtil.assertNoVulgarity(user.getLastName());
        ValidationUtil.assertValidEmail(user.getEmailAddress());
        userRepository.save(user);
    }

    public User getById(String id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        throw new NotFoundException();
    }

    public User updateVerification(String id, Boolean valid) {
        User user = getById(id);
        user.setVerified(valid);
        return userRepository.save(user);
    }

}
