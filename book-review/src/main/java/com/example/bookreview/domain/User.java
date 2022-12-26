package com.example.bookreview.domain;

import com.example.bookreview.common.Gender;
import com.example.bookreview.domain.listener.UserEntityListener;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString(callSuper = true)
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

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private List<UserHistory> userHistories = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
            return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
