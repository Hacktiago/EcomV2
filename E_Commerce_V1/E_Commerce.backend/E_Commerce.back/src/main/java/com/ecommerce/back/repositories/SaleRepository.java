package com.ecommerce.back.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.back.entities.Sale;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, String> {
    List<Sale> findByClient_UserName(String userName);
}