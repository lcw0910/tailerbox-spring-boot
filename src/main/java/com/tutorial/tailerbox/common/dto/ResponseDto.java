package com.tutorial.tailerbox.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.awt.print.Pageable;

public class ResponseDto {

    @Getter
    @AllArgsConstructor
    public static class Create<T> {
        private int id;
        private T data;
        private String message;
    }

    @Getter
    @AllArgsConstructor
    public static class FindOne<T> {
        private T data;
    }

    @Getter
    @AllArgsConstructor
    public static class FindMany<T> {
        private T data;
    }

    @Getter
    @AllArgsConstructor
    public static class Update<T> {
        private Long affected;
        private T data;
    }

    @Getter
    @AllArgsConstructor
    public static class Delete {
        private Long affected;
    }
}
