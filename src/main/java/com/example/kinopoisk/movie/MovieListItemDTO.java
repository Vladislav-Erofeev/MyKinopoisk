package com.example.kinopoisk.movie;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MovieListItemDTO {
    private Long id;
    private String name;
    private String country;
}
