package com.example.SpringBlog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringBlog.models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
    
}
