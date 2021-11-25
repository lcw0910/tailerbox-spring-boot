package com.tutorial.tailerbox.data.repository;

import com.tutorial.tailerbox.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}