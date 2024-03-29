package com.project.aminutesociety.category.repository;

import com.project.aminutesociety.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
