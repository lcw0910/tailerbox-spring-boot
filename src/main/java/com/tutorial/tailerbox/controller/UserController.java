package com.tutorial.tailerbox.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tutorial.tailerbox.common.dto.ResponseDto;
import com.tutorial.tailerbox.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "users")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void createUser() {}

    @GetMapping
    public PageInfo<HashMap<String, Object>> getUser() {
//        ArrayList<HashMap<String, Object>> result = userService.findAll();

        PageHelper.startPage(2, 5);
        return PageInfo.of(userService.findAll());
//        return new ResponseDto.FindMany<>(PageInfo.of(userService.findAll()));
    }
}
