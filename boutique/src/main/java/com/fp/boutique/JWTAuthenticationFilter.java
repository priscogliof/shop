package com.fp.boutique;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JWTAuthenticationFilter extends OncePerRequestFilter {
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private UserDetailsService userDetailsService;
    
    
    
   

	@Override
	protected void doFilterInternal(jakarta.servlet.http.HttpServletRequest request,
			jakarta.servlet.http.HttpServletResponse response, jakarta.servlet.FilterChain filterChain)
			throws jakarta.servlet.ServletException, IOException {
	     String token = request.getHeader("Authorization");
	        if (token != null && token.startsWith("Bearer ")) {
	            token = token.substring(7);
	            try {
	                Claims claims = Jwts.parser().setSigningKey("your-secret-key".getBytes()).parseClaimsJws(token).getBody();
	                String username = claims.getSubject();
	                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
	                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
	                SecurityContextHolder.getContext().setAuthentication(authentication);
	            } catch (ExpiredJwtException e) {
	                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	            }
	        }
	        filterChain.doFilter(request, response);
	
	  if (SecurityContextHolder.getContext().getAuthentication() != null) {

	        filterChain.doFilter(request, response);

	    } else {

	        // If not authenticated, return an error response

	        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

	    }}

	
}