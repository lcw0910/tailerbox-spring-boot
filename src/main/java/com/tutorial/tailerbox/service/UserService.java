package com.tutorial.tailerbox.service;

import com.tutorial.tailerbox.data.dto.UserDto;
import com.tutorial.tailerbox.data.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto getUser(Long id);

    Page<User> searchUser(Pageable pageable);

    UserDto updateUser();

    UserDto deleteUser();

}
