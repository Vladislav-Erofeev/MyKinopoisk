package com.example.kinopoisk.movie;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MovieMapper {
    public MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    MovieListItemDTO convertMovieToMovieListItemDTO(Movie movie);
}
