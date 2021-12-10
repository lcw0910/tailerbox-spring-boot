package com.tutorial.tailerbox.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<String> exceptionHandler(Exception e) {
        log.error(e.getMessage());
        return ResponseEntity
                .status(500)
                .body("Internal Server Error");
    }
}
