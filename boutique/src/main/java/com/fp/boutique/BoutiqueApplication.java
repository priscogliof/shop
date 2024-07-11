package com.fp.boutique;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.boot.web.servlet.ServletRegistrationBean;

@SpringBootApplication

@EnableJpaRepositories



public class BoutiqueApplication {


	


	public static void main(String[] args) {
		SpringApplication.run(BoutiqueApplication.class, args);
		
		
	}

}
