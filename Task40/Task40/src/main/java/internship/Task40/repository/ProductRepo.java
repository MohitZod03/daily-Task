package internship.Task40.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import internship.Task40.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {
    List<Product> findByPriceGreaterThan(double price);    
}
