package com.visionary.visionary.repository;

import com.visionary.visionary.domain.Category;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category, String> {
}
