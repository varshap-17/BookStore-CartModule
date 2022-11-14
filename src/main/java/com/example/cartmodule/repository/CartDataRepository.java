package com.example.cartmodule.repository;

import com.example.cartmodule.model.CartData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartDataRepository extends JpaRepository<CartData,Long> {
}
