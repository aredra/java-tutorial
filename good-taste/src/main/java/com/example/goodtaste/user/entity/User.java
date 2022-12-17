package com.example.goodtaste.user.entity;

import com.example.goodtaste.common.Auditable;
import com.example.goodtaste.user.dto.Gender;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Slf4j
@Entity
@Getter
@Setter
@Table(indexes = { @Index(columnList = "name")}, uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
@EntityListeners(value = {EntityListeners.class, UserEntityListener.class})
public class User implements Auditable {

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



//    @PrePersist
//    public void prePersist() {
//        log.debug(">>> Pre persist");
//        this.createdAt = OffsetDateTime.now();
//        this.updatedAt = OffsetDateTime.now();
//    }
//    @PreUpdate
//    public void preUpdate() {
//        log.debug(">>> Pre Update");
//        this.updatedAt = OffsetDateTime.now();
//    }
//    @PreRemove
//    public void preRemove() {
//        log.debug(">>> Pre Remove");
//    }
//    @PostPersist
//    public void postPersist() {
//        log.debug(">>> PpostPersist");
//    }
//    @PostUpdate
//    public void postUpdate() {
//        log.debug(">>> PostUpdate");
//    }
//    @PostRemove
//    public void postRemove() {
//        log.debug(">>> postRemove");
//    }
//    @PostLoad
//    public void postLoad() {
//        log.debug(">>> PostLoad");
//    }
}
