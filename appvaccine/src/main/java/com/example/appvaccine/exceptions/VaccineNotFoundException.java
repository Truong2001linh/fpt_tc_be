package com.example.appvaccine.exceptions;

import lombok.AllArgsConstructor;

import java.io.Serial;
@AllArgsConstructor
public class VaccineNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 2L;

    public VaccineNotFoundException(String message) {
        super(message);
    }
}
