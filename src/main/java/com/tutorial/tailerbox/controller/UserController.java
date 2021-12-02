package com.tutorial.tailerbox.controller;

import com.tutorial.tailerbox.common.message.Message;
import com.tutorial.tailerbox.data.dto.UserDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Validated
@RestController
public class UserController {

    @GetMapping(value = "/users")
    public ResponseEntity<Message> getUsers(
            @Valid
            @RequestParam(value = "id", required = false)
            @Min(1)
            @Max(3) Long id
    ) {

        // Set User Data
        UserDto userDto = new UserDto();
        userDto.setUserId("dennis01");
        userDto.setUserName("dennis lee");
        userDto.setEmail("dennis01@tailerbox.com");
        userDto.setId(id);

        // Set Response Message
        Message message = Message.builder()
                .status(HttpStatus.OK)
                .message("SUCCESS")
                .data(userDto)
                .build();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("foo", "bar");

        String className = getClass().getName();
//        String className = this.getClass().getName();

        return ResponseEntity
                .status(HttpStatus.OK)
                .headers(headers)
                .body(message);
    }
}
