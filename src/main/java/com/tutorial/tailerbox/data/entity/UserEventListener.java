package com.tutorial.tailerbox.data.entity;

import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;

public class UserEventListener extends AbstractRepositoryEventListener<User> {

    @Override
    public void onBeforeCreate(User user) {
        System.out.println("onBeforeSave!!!");
    }

    @Override
    public void onAfterDelete(User user) {
        System.out.println("onAfterDelete!!!");
    }
}
