package com.visionary.visionary.controller;

import com.visionary.visionary.mapper.CategoryMapper;
import com.visionary.visionary.model.CategoryDto;
import com.visionary.visionary.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.LinkedList;
import java.util.List;

public class CategoryController {
    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    public CategoryController(CategoryService categoryService, CategoryMapper categoryMapper) {
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public List<CategoryDto> getCategorys() {
        List<CategoryDto> converted = new LinkedList<>();
        categoryService.getAll().iterator()
                .forEachRemaining(category -> converted.add(categoryMapper.toDto(category)));
        return converted;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{categoryId}")
    public CategoryDto getCategory(@PathVariable String id) {
        return categoryMapper.toDto(categoryService.getById(id));
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("")
    public CategoryDto updateCategory(CategoryDto categoryDto) {
        return categoryMapper.toDto(
                categoryService.save(categoryMapper.toEntity(categoryDto))
        );
    }
}
