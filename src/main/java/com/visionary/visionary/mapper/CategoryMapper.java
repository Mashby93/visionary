package com.visionary.visionary.mapper;

import com.fasterxml.uuid.Generators;
import com.visionary.visionary.domain.Category;
import com.visionary.visionary.model.CategoryDto;
import com.visionary.visionary.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CategoryMapper {
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;

    public CategoryMapper(CategoryService categoryService, ModelMapper modelMapper) {
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    public CategoryDto toDto(Category category) {
        CategoryDto cat = modelMapper.map(category, CategoryDto.class);
        return cat;
    }

    public Category toEntity(CategoryDto categoryDto) {
        Category category = modelMapper.map(categoryDto, Category.class);

        if (Objects.nonNull(category.getId())) {
            Category oldCategory = categoryService.getById(category.getId());
            category.setDisplay(oldCategory.getDisplay());
        } else {
            category.setId(Generators.timeBasedGenerator().generate());
        }
        return category;
    }
}
