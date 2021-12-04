package com.tutorial.tailerbox.data.entity;

import com.tutorial.tailerbox.data.dto.UserDto;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Table(name = "users")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "user_id", nullable = false, length = 20)
    private String userId;

    @Column(name = "user_name", nullable = false, length = 45)
    private String userName;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(name = "deleted_at")
    private Timestamp deletedAt;

    @Column(
            name = "created_at",
            nullable = false,
            updatable = false,
            insertable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
    )
    private Timestamp createdAt;

    public UserDto toDto() {
        return UserDto.builder()
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