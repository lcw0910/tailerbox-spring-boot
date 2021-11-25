# Spring Data Rest Tutorial

## application.properties
```properties
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