package com.tutorial.tailerbox.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@WebMvcTest
class UserControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    void createUser() {

    }

    @Test
    void getUsers() {
    }

    @Test
    void getUser() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUser() {
    }
}