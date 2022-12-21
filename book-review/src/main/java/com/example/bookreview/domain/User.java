package com.example.bookreview.domain;

import com.example.bookreview.common.Gender;
import com.example.bookreview.domain.listener.UserEntityListener;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(value = UserEntityListener.class)
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private int age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<UserHistory> userHistories = new ArrayList<>();
}
