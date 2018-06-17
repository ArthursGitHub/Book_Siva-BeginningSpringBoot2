package com.apress.demo.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apress.demo.security.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
