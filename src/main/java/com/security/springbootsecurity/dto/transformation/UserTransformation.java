package com.security.springbootsecurity.dto.transformation;


import com.security.springbootsecurity.dto.UserRegistrationDto;
import com.security.springbootsecurity.models.User;

public class UserTransformation {
    public static UserRegistrationDto fromEntity(User user) {

        UserRegistrationDto userDTO = new UserRegistrationDto();
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setUsername(user.getUsername());

        return userDTO;
    }
}

