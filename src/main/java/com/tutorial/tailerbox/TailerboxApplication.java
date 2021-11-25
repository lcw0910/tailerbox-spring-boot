package com.tutorial.tailerbox;

import com.tutorial.tailerbox.data.entity.UserEventListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TailerboxApplication {

    public static void main(String[] args) {
        SpringApplication.run(TailerboxApplication.class, args);
    }

    @Bean
    UserEventListener userEventListener() {
        return new UserEventListener();
    }
}
