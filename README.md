# Spring Data Rest Tutorial

## application.properties
```properties
# Spring Data Rest Properties
# Logging Level
#logging.level.org.springframework=debug
#logging.level.org.springframework.web=debug

# DB Connection
spring.datasource.url=jdbc:mariadb://localhost:3306/tailerbox
spring.datasource.username=root
spring.datasource.password=root

# Spring Data Rest Properties
spring.data.rest.base-path=/api
spring.data.rest.default-media-type=application/json
spring.data.rest.default-page-size=10
spring.data.rest.max-page-size=50
spring.data.rest.detection-strategy=default
spring.data.rest.limit-param-name=size
spring.data.rest.page-param-name=page
spring.data.rest.sort-param-name=sort
spring.data.rest.return-body-on-create=true
spring.data.rest.return-body-on-update=true


# JPA properties
#spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.open-in-view=true

# property case
spring.jackson.property-naming-strategy=SNAKE_CASE
```

## DB Schema
```mariadb
create table users
(
    id bigint unsigned auto_increment
        primary key,
    user_id varchar(20) not null,
    user_name varchar(45) not null,
    email varchar(100) not null,
    updated_at timestamp null on update current_timestamp(),
    deleted_at datetime null,
    created_at timestamp default current_timestamp() not null
);
```

## Validation
- @Entity > @NotNull, @NotEmtpy, @Email ...

## Projection
```java
package com.tutorial.tailerbox.data.entity;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "user-view", types = {User.class})
public interface UserView {
    String getUserId();

    String getUserName();
}

```
## EventListener
```java
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
```