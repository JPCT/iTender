package com.itender.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itender.model.Product;

public interface ProductRepository extends JpaRepository<Product, UUID> {

    Optional<Product> findByName(String name);

    List<Product> findProductsByProductCategoryId(UUID storeId);

}
