package com.example.bookreview.domain;

import com.example.bookreview.domain.listener.Auditable;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.Modifying;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.OffsetDateTime;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(value = AuditingEntityListener.class)
public class BaseEntity implements Auditable {

    @CreatedDate
    @Column(columnDefinition = "timestamp default current_timestamp", nullable = false, updatable = false)
    private OffsetDateTime createdAt;

    @LastModifiedDate
    @Column(columnDefinition = "timestamp default current_timestamp", nullable = false)
    private OffsetDateTime updatedAt;
}
