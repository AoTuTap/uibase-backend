package com.uibase.category.controller;

import com.uibase.category.dto.CategoryResponse;
import com.uibase.category.entity.Category;
import com.uibase.category.repository.CategoryRepository;
import com.uibase.common.response.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryRepository repository;

    public CategoryController(CategoryRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ApiResponse<List<CategoryResponse>> list() {
        List<CategoryResponse> items = repository.getCategoriesOrdered().stream()
                .map(this::map)
                .toList();
        return ApiResponse.success(items);
    }

    private CategoryResponse map(Category item) {
        return new CategoryResponse(item.getId(), item.getName(), item.getSlug(), item.getType(), item.getSortOrder(), item.getCreatedAt());
    }
}
