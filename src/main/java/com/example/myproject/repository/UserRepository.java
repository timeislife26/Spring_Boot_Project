package com.example.myproject.repository;

import com.example.myproject.entities.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<MyUser, Integer> {
    MyUser findByUsername(String username);

    MyUser createUser(MyUser user);


    @Modifying
    @Transactional
    @Query("UPDATE MyUser u SET u.password = :password WHERE u.username = :username")
    MyUser updatePasswordByUsername(String username, String password);
}

