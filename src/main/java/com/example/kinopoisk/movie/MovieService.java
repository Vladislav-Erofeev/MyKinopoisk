package com.example.kinopoisk.movie;

import com.example.kinopoisk.genre.Genre;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MovieService {
    private final MovieRepository movieRepository;

    private List<Movie> getByGenre(Genre genre, int page, int limit) {

    }
}
