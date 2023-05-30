package com.example.kinopoisk.movie;

import com.example.kinopoisk.genre.Genre;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByGenreListContaining(Genre genre, PageRequest pageRequest);
}
