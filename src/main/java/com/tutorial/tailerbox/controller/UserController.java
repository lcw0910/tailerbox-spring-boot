package com.tutorial.tailerbox.controller;

import com.tutorial.tailerbox.data.dto.UserDto;
import com.tutorial.tailerbox.data.entity.User;
import com.tutorial.tailerbox.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

//@Validated
@RestController
public class UserController {

    UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public ResponseEntity getUsers(
//            Pageable pageable,
//            UserDto userDto,
//            BindingResult bindingResult,
//            @RequestParam(value = "email") @Email @Nullable String email,
            @Valid @RequestParam(value = "id") @Min(50) @Nullable Integer id
    ) {

//        List<ObjectError> errors = bindingResult.getAllErrors();
//        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
//        List<ObjectError> objectErrors = bindingResult.getGlobalErrors();

//        Page<User> userList = userService.searchUser(pageable);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("userList");

    }

    @Valid
    @PostMapping(value = "/user")
    public ResponseEntity createUser(
            @RequestBody UserDto userDto,
            BindingResult bindingResult
            ) {

//        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        /*UserDto userDto = UserDto.builder()
                .userId("test")
                .userName("test")
                .email("test")
//                .createdAt(timestamp)
                .build();*/

        List<ObjectError> errors = bindingResult.getAllErrors();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        List<ObjectError> objectErrors = bindingResult.getGlobalErrors();
        UserDto result = userService.createUser(userDto);
        return ResponseEntity.ok(result);
    }
}
