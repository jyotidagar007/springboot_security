package com.security.springbootsecurity.controllers;

import com.security.springbootsecurity.dto.UserRegistrationDto;
import com.security.springbootsecurity.models.User;
import com.security.springbootsecurity.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/signin")
    public String signin(){
        return "user/login.html";
    }

    @GetMapping("/signup")
    public String signup(){
        return "user/signup.html";
    }

    @PostMapping("/register")
    public String register(UserRegistrationDto registrationDto)
    {
        userService.save(registrationDto);
        return  registrationDto.getUsername() != null ? "redirect:/signin" : "user/profile.html";
    }

    @GetMapping("/user/profile")
    public String profile(){
        return "user/profile.html";
    }

//    @GetMapping("/user")
//    public List<User> getAllUsers()
//    {
//        return userService.getAllUsers();
//    }

    //    @GetMapping("/{username}")
//    public User getUser(@PathVariable("username") String username)
//    {
//        return this.userService.getUser(username);
//    }


}
