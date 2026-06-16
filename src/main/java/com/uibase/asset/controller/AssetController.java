package com.uibase.asset.controller;

import com.uibase.asset.dto.AssetDetailDto;
import com.uibase.asset.dto.AssetSummaryDto;
import com.uibase.asset.entity.Asset;
import com.uibase.asset.repository.AssetRepository;
import com.uibase.common.exception.AppException;
import com.uibase.common.response.ApiResponse;
import com.uibase.common.response.PageResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/assets")
public class AssetController {
    private final AssetRepository repository;

    public AssetController(AssetRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ApiResponse<PageResponse<AssetSummaryDto>> list(
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) String type,
            @RequestParam(defaultValue = "PUBLISHED") String status,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "24") int size
    ) {
        int pageIndex = Math.max(page, 1) - 1;
        int pageSize = Math.min(Math.max(size, 1), 100);
        Pageable pageable = PageRequest.of(pageIndex, pageSize, Sort.by(Sort.Direction.DESC, "createdAt", "id"));
        Page<Asset> result = repository.searchAssets(blankToNull(keyword), blankToNull(type), blankToNull(status), pageable);
        List<AssetSummaryDto> items = result.getContent().stream().map(this::toSummary).toList();
        PageResponse<AssetSummaryDto> response = new PageResponse<>(items, pageIndex + 1, pageSize, result.getTotalElements(), result.getTotalPages());
        return ApiResponse.success(response);
    }

    @GetMapping("/{slug}")
    public ApiResponse<AssetDetailDto> detail(@PathVariable String slug) {
        Asset asset = repository.findBySlug(slug)
                .orElseThrow(() -> new AppException("ASSET_NOT_FOUND", "Asset not found"));
        return ApiResponse.success(toDetail(asset));
    }

    private String blankToNull(String value) {
        if (value == null || value.isBlank()) {
            return null;
        }
        return value.trim();
    }

    private AssetSummaryDto toSummary(Asset asset) {
        return new AssetSummaryDto(
                asset.getId(), asset.getTitle(), asset.getSlug(), asset.getDescription(), asset.getType(),
                asset.getThumbnailUrl(), asset.getPreviewUrl(), asset.getIsFree(), asset.getIsPremium(),
                asset.getStatus(), asset.getCreatedAt(), asset.getUpdatedAt()
        );
    }

    private AssetDetailDto toDetail(Asset asset) {
        return new AssetDetailDto(
                asset.getId(), asset.getTitle(), asset.getSlug(), asset.getDescription(), asset.getType(),
                asset.getThumbnailUrl(), asset.getPreviewUrl(), asset.getIsFree(), asset.getIsPremium(),
                asset.getStatus(), asset.getCreatedAt(), asset.getUpdatedAt()
        );
    }
}
