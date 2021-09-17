package com.security.springbootsecurity.services;

import com.security.springbootsecurity.models.CustomUserDetails;
import com.security.springbootsecurity.models.User;
import com.security.springbootsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = this.userRepository.findByUsername(username);
        if(user == null)
        {
            throw new UsernameNotFoundException("NO USER");
        }
        return new CustomUserDetails(user);
    }
}
