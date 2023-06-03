package com.example.kinopoisk.genre;

public class GenreAlreadyExistException extends Exception{
    public GenreAlreadyExistException(String message) {
        super(message);
    }
}
