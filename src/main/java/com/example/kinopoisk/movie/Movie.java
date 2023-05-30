package com.example.kinopoisk.movie;

import com.example.kinopoisk.genre.Genre;
import jakarta.persistence.*;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Entity
@Data
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String country;
    private String budget;
    private String fees;
    private int views;
    private String short_description;
    private String full_description;

    @ManyToMany(mappedBy = "movieList")
    private List<Genre> genreList;

    public void addGenre(Genre genre) {
        if (genreList == null)
            genreList = new LinkedList<>();
        genreList.add(genre);
    }
}
