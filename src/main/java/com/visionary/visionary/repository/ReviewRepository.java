package com.visionary.visionary.repository;

import com.visionary.visionary.domain.Review;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ReviewRepository extends PagingAndSortingRepository<Review, UUID> {
}
