package com.example.productapp.service;

import com.example.productapp.entity.Product;
import com.example.productapp.exception.NoProductsFoundException;
import com.example.productapp.exception.ProductNotFoundException;
import com.example.productapp.repository.ProductRepository;

import internship.Task40.repository.ProductRepo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepo productRepository;

    public ProductService(ProductRepo productRepository) {
        this.productRepository = productRepository;
    }

    public Product findProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with ID " + id + " not found"));
    }

    public List<Product> findProductsAbovePrice(double price) {
        List<Product> products = productRepository.findByPriceGreaterThan(price);
        if (products.isEmpty()) {
            throw new NoProductsFoundException("No products found with a price greater than " + price);
        }
        return products;
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
}
