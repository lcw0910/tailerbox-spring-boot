package com.tutorial.tailerbox.data.repository;

import com.tutorial.tailerbox.data.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByEmail(@Param("email") String email);

    List<User> findByUserNameIsLike(@Param("userName") String userName);

    /* Add pageable */
    Page<User> findByUserNameContains(@Param("user_name") String userName, Pageable pageable);

}