package com.fp.boutique.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fp.boutique.Repository.ProductRepository;
import com.fp.boutique.Models.Product;

@Service
public class ProductService {

	
	

	@Autowired
	private ProductRepository productRepository = null;

	    public Product createProduit(Product newProduit) {
	        // Perform business logic validation (optional)
	        // ...

	        Product savedProduit = productRepository.save(newProduit);
	        return savedProduit;
	    }

	    public Optional<Product> getProductById(Long id) {

	        return productRepository.findById(id);

	    }
	    public List<Product> getAllProducts() {

	        return productRepository.findAll();

	    }

	

		public void deleteMyProduct(long id) {
			 productRepository.deleteById(id);
			// TODO Auto-generated method stub
			
		}

		public Product updateMyEntity(Long id, Product updatedProduct) {
			
			   Product existingProduct = productRepository.findById(id).orElseThrow();

		        existingProduct.setName(updatedProduct.getName());

		        existingProduct.setDescription(updatedProduct.getDescription());

		        existingProduct.setPrice(updatedProduct.getPrice());

		        existingProduct.setQuantity(updatedProduct.getQuantity());

		        existingProduct.setCode(updatedProduct.getCode());

		        existingProduct.setInventoryStatus(updatedProduct.getInventoryStatus());

		        existingProduct.setCategory(updatedProduct.getCategory());

		        existingProduct.setImage(updatedProduct.getImage());

		        existingProduct.setRating(updatedProduct.getRating());

		        return productRepository.save(existingProduct);

		    }
			
			
	}