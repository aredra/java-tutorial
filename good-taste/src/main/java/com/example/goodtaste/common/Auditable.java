package com.example.goodtaste.common;

import java.time.OffsetDateTime;

public interface Auditable {
    OffsetDateTime getCreatedAt();

    OffsetDateTime getUpdatedAt();

    void setCreatedAt(OffsetDateTime createdAt);

    void setUpdatedAt(OffsetDateTime updatedAt);
}
