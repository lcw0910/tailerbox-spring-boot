package com.tutorial.tailerbox.data.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tutorial.tailerbox.data.entity.User;
import com.tutorial.tailerbox.data.validator.OnCreate;
import com.tutorial.tailerbox.data.validator.OnUpdate;
import lombok.*;


import javax.validation.constraints.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder(access = AccessLevel.PUBLIC)
public class UserDto {

    @NotNull(groups = OnUpdate.class)
    @Null
    @Min(value = 1, message = "100을 넘어야된다.")
    @Max(value = 5)
    private Long id;

    @NotNull(groups = OnCreate.class)
    private String userId;

    @NotNull
    private String userName;

    @NotNull(groups = OnCreate.class)
    @NotEmpty
    @Email
    private String email;

    private Timestamp updatedAt;

    private Timestamp deletedAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private Timestamp createdAt;

    public User toEntity() {
        return User.builder()
                .id(id)
                .userId(userId)
                .userName(userName)
                .email(email)
                .updatedAt(updatedAt)
                .createdAt(createdAt)
                .deletedAt(deletedAt)
                .build();
    }
}
