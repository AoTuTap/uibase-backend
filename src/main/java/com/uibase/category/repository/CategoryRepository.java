package com.uibase.category.repository;

import com.uibase.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("select c from Category c order by c.sortOrder asc, c.id asc")
    List<Category> getCategoriesOrdered();
}
