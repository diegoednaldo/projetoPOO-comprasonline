package com.comprasonline.projectPOO.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comprasonline.projectPOO.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}