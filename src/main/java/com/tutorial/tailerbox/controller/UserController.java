package com.tutorial.tailerbox.controller;

import com.tutorial.tailerbox.data.entity.User;
import com.tutorial.tailerbox.data.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/users")
    public List<User> getUsers(@RequestParam Map<String, String> params) {
        log.info("RequestParam : {}", params);
        return userRepository.findAll();
    }
}
