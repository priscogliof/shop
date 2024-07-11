package com.fp.boutique.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


import com.fp.boutique.Models.Product;
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Optional: Custom repository m{

}
