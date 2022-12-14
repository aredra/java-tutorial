package com.example.goodtaste.user.entity;

import com.example.goodtaste.user.dto.Gender;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Getter
@Setter
@Table(indexes = { @Index(columnList = "name")}, uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Transient
    private String secret;

    @Column(insertable = false)
    private OffsetDateTime createdAt;

    @Column(updatable = false)
    private OffsetDateTime updatedAt;

}
