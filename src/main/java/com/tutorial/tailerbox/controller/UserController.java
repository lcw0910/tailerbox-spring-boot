package com.tutorial.tailerbox.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tutorial.tailerbox.data.dto.UserDto;
import com.tutorial.tailerbox.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "users")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public Long createUser(@RequestBody UserDto userDto) {
//        log.info("call createUser !!");
//        log.info(userDto.toString());
        return userService.insertUser(userDto);
    }

    @GetMapping
    public PageInfo<HashMap<String, Object>> getUsers() {
//        ArrayList<HashMap<String, Object>> result = userService.findAll();

        PageInfo pageinfo = new PageInfo(
                PageHelper.startPage(2, 5)
        );
        List list = pageinfo.getList();
        return PageInfo.of(userService.findAll());
//        return new ResponseDto.FindMany<>(PageInfo.of(userService.findAll()));
    }

    @GetMapping(value = "/{id}")
    public UserDto getUser(@PathVariable(value = "id") Long id) {
        return null;
    }

    @PutMapping(value = "/{id}")
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return null;
    }

    @DeleteMapping(value = "/{id}")
    public Long deleteUser(@PathVariable(value = "id") Long id) {
        return null;
    }

}
