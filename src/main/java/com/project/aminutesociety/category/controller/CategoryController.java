package com.project.aminutesociety.category.controller;

import com.project.aminutesociety.category.dto.CategorySetDto;
import com.project.aminutesociety.category.service.CategoryServiceImpl;
import com.project.aminutesociety.util.response.CustomApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Tag(name = "Category", description = "관심분야 관련 API")
@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
@Transactional
public class CategoryController {
    private final CategoryServiceImpl categorySeviceImpl;

    // 카테고리 전체 조회
    @Operation(summary = "카테고리 전체 조회")
    @GetMapping("/read-all")
    public ResponseEntity<CustomApiResponse<?>> readCategories() {
        return categorySeviceImpl.readCategories();
    }

    // 유저 관심분야(카테고리) 설정
    @Operation(summary = "유저 관심분야 설정")
    @PostMapping("/{userId}/set-categories")
    public ResponseEntity<CustomApiResponse<?>> setCategories(@PathVariable String userId, @RequestBody CategorySetDto categorySetDto) {
        return categorySeviceImpl.setCateogires(userId, categorySetDto);
    }

    // 유저 관심분야(카테고리) 변경
    @Operation(summary = "유저 관심분야 변경")
    @PutMapping("/{userId}/change-categories")
    public ResponseEntity<CustomApiResponse<?>> changeCategories(@PathVariable String userId, @RequestBody CategorySetDto categorySetDto) {
        return categorySeviceImpl.changeCategories(userId, categorySetDto);
    }
}