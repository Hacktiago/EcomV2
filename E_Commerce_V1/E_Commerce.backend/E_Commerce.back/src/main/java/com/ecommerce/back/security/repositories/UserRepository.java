package com.ecommerce.back.security.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.back.security.entities.User;

public interface UserRepository extends
        JpaRepository<User, String> {
    Optional<User> findByUserName(String userName);

    boolean existsByUserName(String userName);

}
