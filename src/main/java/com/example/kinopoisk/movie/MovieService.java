package com.example.kinopoisk.movie;

import com.example.kinopoisk.genre.Genre;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MovieService {
    private final MovieRepository movieRepository;

    public List<Movie> getByGenre(Genre genre, int page, int size) {
        return movieRepository.findByGenreListContaining(genre, PageRequest.of(page, size, Sort.by("views")));
    }

    public Movie getById(Long id) throws MovieNotFoundException {
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        if (optionalMovie.isEmpty())
            throw new MovieNotFoundException("Movie with id=" + id + " not found");
        return optionalMovie.get();
    }
}
