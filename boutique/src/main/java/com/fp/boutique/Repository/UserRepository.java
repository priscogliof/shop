package com.fp.boutique.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fp.boutique.Models.Product;
import com.fp.boutique.Models.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);
    // Optional: Custom repository m{

	

} 
