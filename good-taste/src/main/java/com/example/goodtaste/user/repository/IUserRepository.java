package com.example.goodtaste.user.repository;

import com.example.goodtaste.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Map;

public interface IUserRepository extends JpaRepository<User, Long> {

    @Query(value = "select * from user limit 1;", nativeQuery = true)
    Map<String, Object> findLimit1();
}
