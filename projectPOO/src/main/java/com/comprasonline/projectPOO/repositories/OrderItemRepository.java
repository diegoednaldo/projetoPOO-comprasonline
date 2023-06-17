package com.comprasonline.projectPOO.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comprasonline.projectPOO.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
