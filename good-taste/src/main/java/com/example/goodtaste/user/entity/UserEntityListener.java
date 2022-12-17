package com.example.goodtaste.user.entity;

import com.example.goodtaste.support.BeanUtils;
import com.example.goodtaste.user.repository.IUserHistoryRepository;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class UserEntityListener {

    @PrePersist
    @PreUpdate
    public void preSave(Object o) {

        IUserHistoryRepository historyRepository = BeanUtils.getBean(IUserHistoryRepository.class);

        User user = (User) o;
        UserHistory userHistory = new UserHistory();
        userHistory.setUserId(((User) o).getId());
        userHistory.setName(user.getName());
        userHistory.setEmail(user.getEmail());
        historyRepository.save(userHistory);
    }
}
