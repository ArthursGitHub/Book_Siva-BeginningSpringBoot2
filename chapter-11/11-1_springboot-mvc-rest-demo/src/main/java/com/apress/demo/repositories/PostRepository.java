package com.apress.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apress.demo.entities.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
