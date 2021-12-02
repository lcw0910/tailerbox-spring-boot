package com.tutorial.tailerbox.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice(
        annotations = { RestController.class }
)
public class RestControllerExceptionHandler {

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<?> exceptionHandler(Exception e) {
        log.error(e.getMessage());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Internal Server Error");
    }

//    protected ResponseEntity<?>

}
