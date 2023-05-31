package com.example.kinopoisk.post;

public class PostAlreadyExistException extends Exception {
    public PostAlreadyExistException(String message) {
        super(message);
    }
}
