package com.uibase.asset.dto;

import java.time.LocalDateTime;

public record AssetSummaryDto(
        Long id,
        String title,
        String slug,
        String description,
        String type,
        String thumbnailUrl,
        String previewUrl,
        Boolean free,
        Boolean premium,
        String status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
