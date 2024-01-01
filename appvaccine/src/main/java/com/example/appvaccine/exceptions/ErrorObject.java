package com.example.appvaccine.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ErrorObject<T> {
    private Integer statusCode;
    private String message;
    private T content;

    public ErrorObject(Integer statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}

