package com.uibase.platform.controller;

import com.uibase.common.response.ApiResponse;
import com.uibase.platform.dto.PlatformResponse;
import com.uibase.platform.entity.SupportedPlatform;
import com.uibase.platform.repository.PlatformRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/platforms")
public class PlatformController {
    private final PlatformRepository repository;

    public PlatformController(PlatformRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ApiResponse<List<PlatformResponse>> list() {
        List<PlatformResponse> items = repository.findAllByOrderByIdAsc().stream()
                .map(this::map)
                .toList();
        return ApiResponse.success(items);
    }

    private PlatformResponse map(SupportedPlatform item) {
        return new PlatformResponse(item.getId(), item.getName(), item.getCode());
    }
}
