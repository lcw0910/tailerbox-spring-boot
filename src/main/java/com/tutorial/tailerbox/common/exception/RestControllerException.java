package com.tutorial.tailerbox.common.exception;

import org.springframework.http.HttpStatus;

import java.util.Map;

public class RestControllerException extends Exception {

    private String exceptionClass;
    private HttpStatus httpStatus;

    public RestControllerException(String exceptionClass, HttpStatus httpStatus) {
        this.exceptionClass = exceptionClass;
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public int getHttpStatusCode() {
        return httpStatus.value();
    }

    public String getHttpReasonPhrase() {
        return httpStatus.getReasonPhrase();
    }
}
