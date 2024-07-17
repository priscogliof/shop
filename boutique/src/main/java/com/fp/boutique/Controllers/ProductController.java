package com.fp.boutique.Controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.fp.boutique.Models.Product;
import com.fp.boutique.Services.ProductService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

  
    @GetMapping("/products")
    @ResponseBody
    public ResponseEntity<List<Product>> getAllProducts() {
    	System.out.println("all prod");
        List<Product> products = productService.getAllProducts();

        return ResponseEntity.ok(products);

    }
    @GetMapping("products/{id}")
    @ResponseBody
    public ResponseEntity<Product> getProductById(@PathVariable("id") long id) {

        Optional<Product> productData = productService.getProductById(id);

        System.out.println("marche"); System.out.println(productData.toString());
        if (productData.isPresent()) {
        	System.out.println("present");

            return new ResponseEntity<>(productData.get(), HttpStatus.OK);

        } else {
        	System.out.println("pas present");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

    }
   
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    
    @PostMapping("admin/product")

    public ResponseEntity<?> createProduit(@RequestBody Product newProduit) {

        try {

            Product createdProduit = productService.createProduit(newProduit);

            return ResponseEntity.status(HttpStatus.CREATED).header("Access-Control-Allow-Origin:" , "'*'").body(createdProduit);

        } catch (Exception e) {

            logger.error("Error creating product", e);

            ErrorResponse errorResponse = new ErrorResponse("Error creating product", e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);

        }

    }
    
    @DeleteMapping("admin/product/{id}")

    public ResponseEntity<?> deleteMyProduct(@PathVariable long id) {
    	try {
    	productService.deleteMyProduct(id);
    	logger.info("product deleted");
    	}
    	catch(Exception e){
    		logger.error("Error deleteing product", e);
    	}
        return ResponseEntity.status(HttpStatus.OK).build();

    }



@PutMapping("admin/product/{id}")

public ResponseEntity<?> updateMyEntity(@PathVariable Long id, @RequestBody Product updatedMyEntity) {
	try {
		Product updatedEntity = productService.updateMyEntity(id, updatedMyEntity);
		logger.info("product updated");
	}
    catch(Exception e){
		logger.error("Error updating product", e);
	}

    return ResponseEntity.ok(updatedMyEntity);

}

}


class ErrorResponse {

    private String message;

    private String error;


    public ErrorResponse(String message, String error) {

        this.message = message;

        this.error = error;

    }


    // Getters and setters

    public String getMessage() {

        return message;

    }


    public void setMessage(String message) {

        this.message = message;

    }


    public String getError() {

        return error;

    }


    public void setError(String error) {

        this.error = error;

    }

}