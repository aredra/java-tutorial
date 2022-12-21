package com.example.bookreview.domain.listener;

import java.time.OffsetDateTime;

public interface Auditable {

    void setCreatedAt(OffsetDateTime createdAt);

    void setUpdatedAt(OffsetDateTime updatedAt);
}
