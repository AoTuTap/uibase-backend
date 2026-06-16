package com.uibase.category.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    private Long id;
    private String name;
    private String slug;
    private String type;
    @Column(name = "sort_order")
    private Integer sortOrder;
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getSlug() { return slug; }
    public String getType() { return type; }
    public Integer getSortOrder() { return sortOrder; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
