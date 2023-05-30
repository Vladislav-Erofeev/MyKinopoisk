package com.example.kinopoisk.movie;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movie")
public class MovieController {
    private final MovieService movieService;
    private final MovieMapper movieMapper = MovieMapper.INSTANCE;

    @GetMapping("/")
    public List<MovieListItemDTO> getAll(@RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "20") int size) {
        return movieService.getAll(page, size).stream()
                .map(movieMapper::convertMovieToMovieListItemDTO).collect(Collectors.toList());
    }
}
