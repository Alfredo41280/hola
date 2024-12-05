package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Shopping;

@Repository
public interface ShoppingRepository extends JpaRepository <Shopping, Integer>{
    
}
