package com.comprasonline.projectPOO.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comprasonline.projectPOO.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}