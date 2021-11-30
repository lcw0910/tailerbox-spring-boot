package com.tutorial.tailerbox.controller;

import com.tutorial.tailerbox.common.message.Message;
import com.tutorial.tailerbox.data.dto.UserDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping(value = "/users")
    public ResponseEntity<Message> getUsers() {

        // Set User Data
        UserDto userDto = new UserDto();
        userDto.setUserId("dennis01");
        userDto.setUserName("dennis lee");
        userDto.setEmail("dennis01@tailerbox.com");

        // Set Response Message
        Message message = Message.builder()
                .status(HttpStatus.OK)
                .message("SUCCESS")
                .data(userDto)
                .build();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("foo", "bar");

        return ResponseEntity
                .status(HttpStatus.OK)
                .headers(headers)
                .body(message);
    }
}
