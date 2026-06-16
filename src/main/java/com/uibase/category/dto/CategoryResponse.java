package com.uibase.category.dto;

import java.time.LocalDateTime;

public record CategoryResponse(
        Long id,
        String name,
        String slug,
        String type,
        Integer sortOrder,
        LocalDateTime createdAt
) {
}
