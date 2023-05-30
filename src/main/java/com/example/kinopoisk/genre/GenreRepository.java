package com.example.kinopoisk.genre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface GenreRepository extends JpaRepository<Genre, Long> {
}
