package com.example.kinopoisk.genre;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
interface GenreMapper {
    GenreMapper INSTANCE = Mappers.getMapper(GenreMapper.class);

    GenreDTO convertToGenreDTO(Genre genre);

    Genre convertNewGenreDTOToGenre(NewGenreDTO newGenreDTO);
}
