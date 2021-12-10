package com.tutorial.tailerbox.service;

import com.tutorial.tailerbox.data.dto.UserDto;
import com.tutorial.tailerbox.data.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class UserService {

    UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public UserDto insertUser(UserDto userDto) {
        userMapper.insertUser(userDto);
        return userDto;
    }

    public ArrayList<HashMap<String, Object>> findAll() {
        return userMapper.findAll();
    }
}
