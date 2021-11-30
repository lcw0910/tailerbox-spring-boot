package com.tutorial.tailerbox.common.exception;

import com.tutorial.tailerbox.controller.UserController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice(assignableTypes = UserController.class)
@Order(Ordered.HIGHEST_PRECEDENCE)
public class UserExceptionHandler {

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<?> handleException (Exception e) {
        log.error("UserException " + e.getMessage());
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("This is User Controller Handler");
    }

}

