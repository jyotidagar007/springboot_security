package com.security.springbootsecurity.services;

import com.security.springbootsecurity.dto.UserRegistrationDto;
import com.security.springbootsecurity.models.Role;
import com.security.springbootsecurity.models.User;
import com.security.springbootsecurity.repository.RoleRepository;
import com.security.springbootsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    public User save(UserRegistrationDto registrationDto) {
        User user = getCurrentUser();

        if(user != null)
        {
            user.setFirstName(registrationDto.getFirstName());
            user.setLastName(registrationDto.getLastName());
            user.setPassword(registrationDto.getPassword());
        }
        else {
            Set<Role> hs = new HashSet<Role>();

            hs.add(roleRepository.findByName("ROLE_ADMIN"));
       //     hs.add(roleRepository.findByName("CREATOR"));

             user = new User(registrationDto.getFirstName(),
                    registrationDto.getLastName(), registrationDto.getUsername(),
                     passwordEncoder.encode(registrationDto.getPassword()), hs);
        }
        userRepository.save(user);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);

        if(user == null)
        {
            throw new UsernameNotFoundException("NO USER");
        }
        return user;
    }

    public User getCurrentUser(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        return userRepository.findByUsername(username);
    }

    public void deleteTask() {
        User user = getCurrentUser();
        userRepository.delete(user);
    }
}
