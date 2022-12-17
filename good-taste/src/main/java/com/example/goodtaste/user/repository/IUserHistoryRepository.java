package com.example.goodtaste.user.repository;

import com.example.goodtaste.user.entity.UserHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserHistoryRepository extends JpaRepository<UserHistory, Long> {
}
