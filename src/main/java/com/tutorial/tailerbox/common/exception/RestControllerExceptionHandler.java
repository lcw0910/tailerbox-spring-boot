package com.tutorial.tailerbox.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
                .body(e.getLocalizedMessage());
    }

    @ExceptionHandler(value = {ConstraintViolationException.class})
    protected ResponseEntity handleConstraintViolation(ConstraintViolationException e) {
        log.error(e.getMessage());
        return ResponseEntity.unprocessableEntity().body(e.getLocalizedMessage());
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    protected ResponseEntity missingServletRequestParameterExceptionHandler(
            MissingServletRequestParameterException e
    ) {
        return ResponseEntity.unprocessableEntity().body(e.getLocalizedMessage());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    protected ResponseEntity methodArgumentTypeMismatchExceptionHandler(
            MethodArgumentTypeMismatchException e
    ) {
        log.error(e.getMessage());
        String errorCode = e.getErrorCode();

        return ResponseEntity.unprocessableEntity().body(e.getLocalizedMessage());
    }

    @ExceptionHandler(BindException.class)
    protected ResponseEntity bindExceptionHandler(BindException e) {

        log.error(e.getMessage());

        List<FieldError> fieldErrors = e.getFieldErrors();
        List<ObjectError> objErrors = e.getAllErrors();

//        ArrayList<String> errors = new ArrayList<>();
        List<String> errors = new ArrayList<String>();
        e.getFieldErrors().forEach(error -> {
//            log.error("Field : {}", error.getField());
//            log.error("RejectedValue : {}", error.getRejectedValue());
//            log.error("DefaultMessage : {}", error.getDefaultMessage());
//            errors.add(error.getDefaultMessage());
            List<String> splitErrors = Arrays.asList(error.getDefaultMessage().split(";"));
//            errors.add(splitErrors.get(0));
            errors.add(error.getField() + ':' + error.getDefaultMessage());
        });
        ArrayList<String> errorMessages = new ArrayList<>();
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(errors);
    }

//    protected ResponseEntity<?>

}
