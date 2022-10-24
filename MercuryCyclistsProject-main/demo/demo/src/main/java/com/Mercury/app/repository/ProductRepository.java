package com.Mercury.app.repository;


import com.Mercury.app.model.InventoryDomain.Aggregate.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findProductById(Long productId);
    Optional<Product> findProductByName(String productName);
}
