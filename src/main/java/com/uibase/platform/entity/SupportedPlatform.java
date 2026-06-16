package com.uibase.platform.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "platforms")
public class SupportedPlatform {
    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
}
