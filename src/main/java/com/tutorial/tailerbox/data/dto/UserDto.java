package com.tutorial.tailerbox.data.dto;

import com.sun.istack.NotNull;
import lombok.*;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder(access = AccessLevel.PUBLIC)
public class UserDto {

    @NotNull
    private Long id;

    @NotNull
    private String userId;

    @NotNull
    private String userName;

    @NotNull
    private String email;

    private Timestamp updatedAt;

    private Timestamp deletedAt;

    private Timestamp createdAt;

}
