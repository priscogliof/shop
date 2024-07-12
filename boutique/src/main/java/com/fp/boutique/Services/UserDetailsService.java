package com.fp.boutique.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fp.boutique.Models.User;
import com.fp.boutique.Repository.UserRepository;

@Service

public class UserDetailsService  {

    

    @Autowired

    private UserRepository userRepository;

    

    public User loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);

        if (user == null) {

            throw new UsernameNotFoundException("User not found");

        }

        return new User(user.getUsername(), user.getPassword(), user.getRoles());

    }

    

    }

