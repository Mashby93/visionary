package com.visionary.visionary.mapper;

import com.fasterxml.uuid.Generators;
import com.visionary.visionary.domain.User;
import com.visionary.visionary.model.PrivateUserProfileDto;
import com.visionary.visionary.model.PublicUserProfileDto;
import com.visionary.visionary.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UserMapper {
    private final ModelMapper modelMapper;
    private final UserService userService;

    @Autowired
    public UserMapper(ModelMapper modelMapper, UserService userService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    public PublicUserProfileDto publicUserProfileDto(User user) {
        return modelMapper.map(user, PublicUserProfileDto.class);
    }

    public PrivateUserProfileDto privateUserProfileDto(User user) {
        return modelMapper.map(user, PrivateUserProfileDto.class);
    }

    public User toUser(PrivateUserProfileDto privateUserProfileDto) {
        User user = modelMapper.map(privateUserProfileDto, User.class);
        user.setVerified(false);
        user.setAverageReview(0.0);
        if (Objects.nonNull(user.getId())) {
            User oldUser = userService.getById(user.getId());
            user.setVerified(oldUser.getVerified());
            user.setAverageReview(oldUser.getAverageReview());
        } else {
            user.setId(Generators.timeBasedGenerator().generate());
        }
        return user;
    }

}
