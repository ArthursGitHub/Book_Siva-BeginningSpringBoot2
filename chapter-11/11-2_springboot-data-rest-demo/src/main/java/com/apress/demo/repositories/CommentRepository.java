package com.apress.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apress.demo.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
