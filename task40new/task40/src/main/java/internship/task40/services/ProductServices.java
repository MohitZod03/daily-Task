package internship.task40.services;

import internship.task40.entity.Product;
import internship.task40.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServices {
    @Autowired
    private ProductRepo productRepo;

    // Save product to the database
    public String saveProduct(Product product) {
        productRepo.save(product);
        return "Product saved successfully!";
    }

    // Retrieve all products
    public List<Product> getAll() {
        return productRepo.findAll();
    }

    // Retrieve product by ID
    public Product getById(Long id) {
        return productRepo.findById(id).orElseThrow(() -> new RuntimeException("Product not found with ID: " + id));
    }
}
