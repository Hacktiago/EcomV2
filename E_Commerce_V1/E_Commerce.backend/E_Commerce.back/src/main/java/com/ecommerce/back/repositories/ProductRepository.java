package com.ecommerce.back.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.back.entities.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findByCategoryAndIdNot(String category, String ProductId);

    List<Product> findFirst4ByOrderByPriceAsc();
}