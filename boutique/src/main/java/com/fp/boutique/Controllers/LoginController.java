package com.fp.boutique.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import com.fp.boutique.Models.LoginRequest;
import com.fp.boutique.Services.ProductService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private  AuthenticationManager authenticationManager ;
    
    /*public LoginController(AuthenticationManager AuthenticationManager) {
        this.authenticationManager = AuthenticationManager;
    }*/
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        Date expirationDate = Date.from(Instant.now().plus(Duration.ofHours(1)));
        String token = Jwts.builder()
               .setSubject(authentication.getName())
               .claim("roles", authentication.getAuthorities())
               .setExpiration(expirationDate)
               .signWith(SignatureAlgorithm.HS256, "your-secret-key")
               .compact();

        return token;
    }
}