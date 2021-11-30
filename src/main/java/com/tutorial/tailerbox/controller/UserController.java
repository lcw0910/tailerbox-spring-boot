package com.tutorial.tailerbox.controller;


import com.tutorial.tailerbox.data.entity.User;
import com.tutorial.tailerbox.data.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class UserController {

    private UserRepository userRepository;

    UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "user/{id}")
    public ResponseEntity<?> user(@PathVariable("id") long id) throws Exception {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new Exception("No Data Found");
        }
        return ResponseEntity.ok().body(user);

        // Controller 내에서 예외 처리
        /*try {
            Optional<User> user = userRepository.findById(id);
            if (user.isEmpty()) {
                throw new Exception("No Data Found");
            }
            return ResponseEntity.ok().body(user);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.OK).body("No Data (catch block)");
        }*/
    }

    /*@ExceptionHandler(Exception.class)
    protected ResponseEntity<?> handleException (Exception e) {
        log.error(e.getMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Bad Request");
    }*/

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "users")
    public List<User> users()
    {
        log.info("UserController.users");
        List<User> users = userRepository.findAll();
        return users;
    }
}
