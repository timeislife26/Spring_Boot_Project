package com.example.myproject.repository;

import com.example.myproject.entities.MyUser;
import com.example.myproject.daos.dtos.PetNameAndBreed;
import com.example.myproject.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.nio.channels.FileChannel;
@Repository
public interface UserServiceRepository {
    MyUser createUser(MyUser user);

    MyUser editUserPassword(String userName, String newPassword);

    MyUser toggleUserUnlock(String username);

    void deleteUser(String username);

}
