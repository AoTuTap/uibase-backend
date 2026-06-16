package com.uibase.asset.repository;

import com.uibase.asset.entity.Asset;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AssetRepository extends JpaRepository<Asset, Long> {

    Optional<Asset> findBySlug(String slug);

    @Query("""
            select a from Asset a
            where (:status is null or a.status = :status)
              and (:type is null or a.type = :type)
              and (
                :keyword is null
                or lower(a.title) like lower(concat('%', :keyword, '%'))
                or lower(a.description) like lower(concat('%', :keyword, '%'))
              )
            """)
    Page<Asset> searchAssets(
            @Param("keyword") String keyword,
            @Param("type") String type,
            @Param("status") String status,
            Pageable pageable
    );
}
