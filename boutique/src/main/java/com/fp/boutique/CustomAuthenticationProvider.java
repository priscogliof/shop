package com.fp.boutique;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.Authentication;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.fp.boutique.Models.User;

import com.fp.boutique.Repository.UserRepository;


public class CustomAuthenticationProvider implements AuthenticationProvider {


    @Autowired

    private UserRepository userRepository;


    @Override

    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();

        String password = authentication.getCredentials().toString();


        User user = userRepository.findByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
        	System.out.println("connecté");

        	return new UsernamePasswordAuthenticationToken(

        		    user, 

        		    password, 

        		    Stream.of(user.getRoles().split(","))

        		       .map(role -> role.strip())

        		       .map(role -> new SimpleGrantedAuthority(role))

        		       .collect(Collectors.toList())

        		);
        } else {

            throw new BadCredentialsException("Invalid username or password");

        }
    }
    


    @Override

    public boolean supports(Class<?> authentication) {

        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);

    }




}