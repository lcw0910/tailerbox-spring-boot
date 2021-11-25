package com.tutorial.tailerbox.data.entity;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "user-view", types = {User.class})
public interface UserView {
    String getUserId();

    String getUserName();
}
