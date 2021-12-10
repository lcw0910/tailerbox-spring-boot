package com.tutorial.tailerbox.common.http;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URI;

@Getter
@Setter
public class Response<T> {

    /*public static ResponseEntity<HashMap<String, Integer>> created() {
        HashMap<String, Integer> body = new HashMap<>();
        body.put("status", 201);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(body);
    }*/

    public static <T> ResponseEntity<Created<T>> created(T data, URI... uris) {

        Response.Created<T> body = new Response.Created<>(data);

        if (uris.length > 0) {
            return ResponseEntity
                    .created(uris[0])
                    .body(body);
        }
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(body);
    }

    @Getter
    @Setter
    public static class Created<T> {
        private String code;
        private String message;
        private T data;

        public Created(T data) {
            this.data = data;
            this.code = "SUCCESS.CREATED";
            this.message = "성공";
        }
    }
}