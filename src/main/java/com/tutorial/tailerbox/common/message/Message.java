package com.tutorial.tailerbox.common.message;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class Message {

    private HttpStatus status;
    private String message;
    private Object data;

}
