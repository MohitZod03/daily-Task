package internship.task40.controller;

import internship.task40.entity.Product;
import internship.task40.services.ProductServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductServices productServices;

    // Save product
    @PostMapping("/save")
    public ResponseEntity<String> saveProduct(@Valid @RequestBody Product product) {
        logger.info("Received Product: {}", product);
        productServices.saveProduct(product);
        return new ResponseEntity<>("Product saved successfully!", HttpStatus.CREATED);
    }


    // Get all products
    @GetMapping("/getAll")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productServices.getAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    // Get product by ID
    @GetMapping("/getById/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productServices.getById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
