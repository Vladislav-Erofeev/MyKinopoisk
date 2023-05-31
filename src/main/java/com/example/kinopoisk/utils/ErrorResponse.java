package com.example.kinopoisk.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
public class ErrorResponse {
    private String message;
    private long timestamp;
    public ErrorResponse(String message) {
        this.message = message;
        timestamp = System.currentTimeMillis();
    }
}
