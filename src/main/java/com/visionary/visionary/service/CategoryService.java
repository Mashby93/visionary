package com.visionary.visionary.service;

import com.visionary.visionary.domain.Category;
import com.visionary.visionary.repository.CategoryRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category getById(UUID id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            return category.get();
        }
        throw new NullPointerException();
    }

    public Iterable<Category> getAll() {
        return categoryRepository.findAll(Sort.by("name").descending());
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }
}
