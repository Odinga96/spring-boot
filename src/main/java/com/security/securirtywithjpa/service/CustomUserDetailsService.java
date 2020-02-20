package com.security.securirtywithjpa.service;

import com.security.securirtywithjpa.model.CustomUserDetails;
import com.security.securirtywithjpa.model.User;
import com.security.securirtywithjpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService  implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String firstName) throws UsernameNotFoundException {

        Optional<User> userOptional=repository.findByFirstName(firstName);

        userOptional.orElseThrow(() -> new UsernameNotFoundException("Username not found"));

        return userOptional.map(CustomUserDetails::new).get();
    }
}
