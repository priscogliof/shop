package com.fp.boutique;

import java.security.AuthProvider;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fp.boutique.Services.UserDetailsService;

@Configuration
@EnableWebSecurity
public class Security {
	
	@Autowired

	  private UserDetailsService userDetailsService;
	
	/*@Autowired

	  private JWTAuthenticationFilter jwtAuthenticationFilter;*/

	  @Bean

	  public UserDetailsService userDetailsService() {

	    return new UserDetailsService();

	  }

	  

	  @Bean

	  public PasswordEncoder passwordEncoder() {

	    return new BCryptPasswordEncoder();

	  }
	  @Bean

	    public CustomAuthenticationProvider customAuthenticationProvider() {
		  return new CustomAuthenticationProvider();
	  };

	  @Bean

	  public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {

	      return authenticationConfiguration.getAuthenticationManager();

	  }
	  
	  

	  @Bean
	  public ProviderManager authenticationProvider() {
	      return new ProviderManager(new AuthenticationProvider[]{customAuthenticationProvider()});
	  }

	  /*@Bean
	  public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {

		    return http.getSharedObject(AuthenticationManagerBuilder.class).build();

		}*/
	  /*@Bean

	  public JWTAuthenticationFilter jwtAuthenticationFilter() {

	    return new JWTAuthenticationFilter();

	  }*/
  
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.csrf().disable()
        .authorizeRequests()
        .requestMatchers("/**").permitAll();
    return http.build();
  }
  
  /*@Bean

  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

    http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

    return http.build();

  }*/
  
  @Bean
  CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();
    configuration.setAllowedOrigins(Arrays.asList("*"));
    configuration.setAllowedMethods(Arrays.asList("GET", "HEAD", "POST", "PUT", "DELETE"));
    configuration.setAllowedHeaders(Arrays.asList("*"));
    configuration.addAllowedHeader("*");
    configuration.setAllowCredentials(true);
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return source;
  }
  
  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
            .allowedOrigins("http://localhost:4200") // Allow requests from Angular app
            .allowedMethods("GET", "POST", "PUT", "DELETE")
            .maxAge(3600);
        
        registry.addMapping("/api/product")
            .allowedOrigins("http://localhost:4200") // Allow requests from Angular app
            .allowedMethods("GET", "POST", "PUT", "DELETE")
            .maxAge(3600);
      }
    };
  }
  
 
}