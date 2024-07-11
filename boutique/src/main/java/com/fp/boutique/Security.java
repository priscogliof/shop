package com.fp.boutique;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class Security {
	
	
    //we have stopped the csrf to make post method work

        protected void configure(HttpSecurity http) throws Exception{
            http.cors().and().csrf().disable();
            
        }
        @Bean
        CorsConfigurationSource corsConfigurationSource() {
            CorsConfiguration configuration = new CorsConfiguration();
            configuration.setAllowedOrigins(Arrays.asList("*"));
            configuration.setAllowedMethods(Arrays.asList(" HttpMethod.GET.name(),\r\n"
            		+ "                HttpMethod.HEAD.name(),\r\n"
            		+ "                HttpMethod.POST.name(),\r\n"
            		+ "                HttpMethod.PUT.name(),\r\n"
            		+ "                HttpMethod.DELETE.name()"));
            configuration.setAllowedHeaders(Arrays.asList("*"));
            configuration.addAllowedHeader("*");
            configuration.setAllowCredentials(true);
            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            source.registerCorsConfiguration("/**", configuration);
            return source;
        }

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .requestMatchers("/api/**").permitAll(); // Allow access to public resources
        // Require authentication for other requests .anyRequest();
        // Enable form-based login (optional)
        return http.build();
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