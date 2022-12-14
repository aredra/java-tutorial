package com.example.goodtaste.user.repository;

import com.example.goodtaste.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
}
