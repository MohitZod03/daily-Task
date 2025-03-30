package internship.Task40.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import internship.Task40.entity.Product;
import internship.Task40.helper.Responses;
import internship.Task40.services.ProductServices;

@RestController
@RequestMapping("api/products")
public class ProductController {
    @Autowired
    private ProductServices productServices;

    @PostMapping("/save")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        Product savedProduct = productServices.saveProduct(product);
        return new ResponseEntity<>(new Responses(true, "Product saved successfully", savedProduct), HttpStatus.OK);}
    @GetMapping("/all")
    public ResponseEntity<?> getAllProducts() {
        return new ResponseEntity<>(productServices.getAllProducts(), HttpStatus.OK);
    }
    @GetMapping("/find")
    public ResponseEntity<?> findProductAbovePrice(double price) {
        return new ResponseEntity<>(productServices.findProductAbovePrice(price), HttpStatus.OK);
    }
    @GetMapping("/get")
    public ResponseEntity<?> getProductById(Long id) {
        return new ResponseEntity<>(productServices.getProductById(id), HttpStatus.OK);
    }

    
    
}
