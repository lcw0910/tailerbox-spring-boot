package com.tutorial.tailerbox.service;

import com.tutorial.tailerbox.data.dto.UserDto;
import com.tutorial.tailerbox.data.entity.User;
import com.tutorial.tailerbox.data.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(UserDto userDto) {

        if (userDto.getCreatedAt() == null) {
            userDto.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        }

        User user = userRepository.save(userDto.toEntity());
        return user.toDto();
    }

    @Override
    public UserDto getUser(Long id) {
        User user = userRepository.getById(id);
        return UserDto.builder()
                .id(user.getId())
                .userId(user.getUserId())
                .email(user.getEmail())
                .userName(user.getUserName())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }

    @Override
//    public List<UserDto> searchUser() {
    public Page<User> searchUser(Pageable pageable) {
        /*Pageable pageable = PageRequest.of(1,5, Sort.by(
                Sort.Order.asc("id")
        ));*/
        Page<User> userList = userRepository.findAll(pageable);

//        userRepository.

        return userList;
    }

    @Override
    public UserDto updateUser() {
        return null;
    }

    @Override
    public UserDto deleteUser() {
        return null;
    }

}
