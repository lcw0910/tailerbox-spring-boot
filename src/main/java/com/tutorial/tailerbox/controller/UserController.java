package com.tutorial.tailerbox.controller;

import com.github.pagehelper.PageInfo;
import com.tutorial.tailerbox.common.http.Response;
import com.tutorial.tailerbox.data.dto.UserDto;
import com.tutorial.tailerbox.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(value = "${routes.api-base-uri}/users")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Response.Created<UserDto>> createUser(
            @RequestBody UserDto userDto,
            HttpServletRequest request
    ) {

        UserDto createdUser = userService.insertUser(userDto);
        String location = request
                .getRequestURL()
                .toString()
                .concat("/")
                .concat(createdUser.getId().toString());

        try {
            return Response.created(createdUser, new URI(location));
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return Response.created(createdUser);
        }
    }

    @GetMapping
    public PageInfo<HashMap<String, Object>> getUsers() {
//        ArrayList<HashMap<String, Object>> result = userService.findAll();

        /*PageInfo pageinfo = new PageInfo(
                PageHelper.startPage(2, 5)
        );
        List list = pageinfo.getList();
        return PageInfo.of(userService.findAll());*/
//        return new ResponseDto.FindMany<>(PageInfo.of(userService.findAll()));
        return null;
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
