package com.samlportal.samlportal.repository;

import com.samlportal.samlportal.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {

    // Top-level posts (not replies)
    List<Post> findByPostRefIsNullOrderByCreatedAtDesc();

    // Replies to a post
    List<Post> findByPostRefOrderByCreatedAtAsc(UUID postId);


}
