package com.example.kinopoisk.post;

class PostNotFoundException extends Exception {
    public PostNotFoundException(String message) {
        super(message);
    }
}