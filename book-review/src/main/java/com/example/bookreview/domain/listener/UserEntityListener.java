package com.example.bookreview.domain.listener;

import com.example.bookreview.domain.User;
import com.example.bookreview.domain.UserHistory;
import com.example.bookreview.repository.UserHistoryRepository;
import com.example.bookreview.utils.BeanUtils;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;

public class UserEntityListener {

    @PostPersist
    @PostUpdate
    public void insertUserHistory(Object o) {

        UserHistoryRepository historyRepository = BeanUtils.getBean(UserHistoryRepository.class);

        User user = (User) o;
        UserHistory userHistory = new UserHistory();
        userHistory.setUser(user);
        userHistory.setName(user.getName());
        userHistory.setAge(user.getAge());
        userHistory.setGender(user.getGender());
        historyRepository.save(userHistory);
    }
}
