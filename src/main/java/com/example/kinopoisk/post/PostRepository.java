package com.example.kinopoisk.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findByNameIgnoreCase(String name);
}
