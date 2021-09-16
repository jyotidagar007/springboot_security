package com.security.springbootsecurity.services;

import com.security.springbootsecurity.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    List<User> list = new ArrayList<>();

    public UserService() {
        list.add(new User("abc", "abc", "abc@example.com"));
        list.add(new User( "xyz", "xyz", "xyz@example.com"));
        list.add(new User( "pqr", "pqr", "pqr@example.com"));
    }
    

       public List<User> getAllUsers()
       {
           return this.list;
       }

    public User getUser(String username)
    {
        return this.list.stream().filter(user -> user.getUserName().equals(username)).findAny().orElse(null);
    }

    public User addUser(User user)
    {
        this.list.add(user);
        return user;
    }
}