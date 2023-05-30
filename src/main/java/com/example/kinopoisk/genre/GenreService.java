package com.example.kinopoisk.genre;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GenreService {
    private final GenreRepository genreRepository;

    public Genre getById(Long id) throws GenreNotFoundException {
        Optional<Genre> optionalGenre = genreRepository.findById(id);
        if (optionalGenre.isEmpty())
            throw new GenreNotFoundException("Genre with id=" + id + " not found");
        return optionalGenre.get();
    }

    public List<Genre> getAll() {
        return genreRepository.findAll();
    }

    @Transactional
    public void save(Genre genre) {
        genreRepository.save(genre);
    }

    @Transactional
    public void delete(Long id) {
        genreRepository.deleteById(id);
    }
}
