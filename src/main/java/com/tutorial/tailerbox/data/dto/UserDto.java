package com.tutorial.tailerbox.data.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;

    private String userId;

    private String userName;

    private String email;

}
