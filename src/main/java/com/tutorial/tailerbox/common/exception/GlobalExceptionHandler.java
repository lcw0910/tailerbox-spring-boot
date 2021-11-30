package com.tutorial.tailerbox.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



// 구체적인 핸들링 대상의 특징을 명시
/*@RestControllerAdvice(
        annotations = { RestController.class },
        basePackages = { "com.tutorial.tailerbox.controller" },
        basePackageClasses = { UserController.class },
        assignableTypes = { ErrorController.class }
)*/

@Slf4j
// 일반적인 전역 핸들러
@RestControllerAdvice

// ControllerAdvice 의 우선순위가 필요한 경우
//@Order(Ordered.LOWEST_PRECEDENCE)
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<?> handleException (Exception e) {
        log.error("ErrorController " + e.getMessage());
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("No Content");
    }

}
