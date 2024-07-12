package com.fp.boutique.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fp.boutique.Models.User;
import com.fp.boutique.Repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserDetailsServiceImpl extends UserDetailsService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Override
    @Transactional
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        
        return user;
    }
}
