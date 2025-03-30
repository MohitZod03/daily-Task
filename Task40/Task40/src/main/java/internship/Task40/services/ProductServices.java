package internship.Task40.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import internship.Task40.entity.Product;

public interface ProductServices {

    ResponseEntity<Product> saveProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(Long id);
    List<Product> findProductAbovePrice(double price);    
    
}
