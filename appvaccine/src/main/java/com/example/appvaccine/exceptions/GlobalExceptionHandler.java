package com.example.appvaccine.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorObject> handleUserNotFoundException(UserNotFoundException ex) {
        ErrorObject error = new ErrorObject();
        error.setStatusCode(404); // Not Found
        error.setMessage(ex.getMessage());
        error.setContent("Thông tin chi tiết về lỗi người dùng không tìm thấy");

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(VaccineNotFoundException.class)
    public ResponseEntity<ErrorObject> handleUserNotFoundException(VaccineNotFoundException ex) {
        ErrorObject error = new ErrorObject();
        error.setStatusCode(404); // Not Found
        error.setMessage(ex.getMessage());
        error.setContent("Thông tin chi tiết về lỗi người dùng không tìm thấy");

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
