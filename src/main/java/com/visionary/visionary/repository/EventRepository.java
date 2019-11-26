package com.visionary.visionary.repository;

import com.visionary.visionary.domain.Event;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EventRepository extends PagingAndSortingRepository<Event, UUID>, CustomEventRepository {
}
