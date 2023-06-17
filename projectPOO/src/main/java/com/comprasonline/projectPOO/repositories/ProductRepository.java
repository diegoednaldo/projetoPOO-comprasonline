package com.comprasonline.projectPOO.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comprasonline.projectPOO.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
