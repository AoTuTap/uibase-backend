package com.uibase.asset.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "assets")
public class Asset {
    @Id
    private Long id;

    private String title;
    private String slug;
    private String description;
    private String type;

    @Column(name = "thumbnail_url")
    private String thumbnailUrl;

    @Column(name = "preview_url")
    private String previewUrl;

    @Column(name = "copy_payload")
    private String copyPayload;

    @Column(name = "download_url")
    private String downloadUrl;

    @Column(name = "is_free")
    private Boolean isFree;

    @Column(name = "is_premium")
    private Boolean isPremium;

    private String status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getSlug() { return slug; }
    public String getDescription() { return description; }
    public String getType() { return type; }
    public String getThumbnailUrl() { return thumbnailUrl; }
    public String getPreviewUrl() { return previewUrl; }
    public String getCopyPayload() { return copyPayload; }
    public String getDownloadUrl() { return downloadUrl; }
    public Boolean getIsFree() { return isFree; }
    public Boolean getIsPremium() { return isPremium; }
    public String getStatus() { return status; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
}
