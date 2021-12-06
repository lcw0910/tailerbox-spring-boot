package com.tutorial.tailerbox.controller;

import com.tutorial.tailerbox.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@Slf4j
@RestController
@RequestMapping(value = "users")
public class UserController {

    UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ArrayList<HashMap<String, Object>> getUsers() {
        ArrayList<HashMap<String, Object>> result = userService.findAll();
        log.info("UserController.getUsers");

        return result;
    }
}
