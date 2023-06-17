package com.comprasonline.projectPOO.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comprasonline.projectPOO.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
