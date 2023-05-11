package com.ecommerce.back.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.back.entities.Detail;

import java.util.List;

public interface DetailRepository extends JpaRepository<Detail, String> {
    List<Detail> findBySale_Id(String saleId);
}