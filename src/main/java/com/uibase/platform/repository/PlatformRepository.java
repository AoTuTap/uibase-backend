package com.uibase.platform.repository;

import com.uibase.platform.entity.SupportedPlatform;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlatformRepository extends JpaRepository<SupportedPlatform, Long> {
    List<SupportedPlatform> findAllByOrderByIdAsc();
}
