package com.visionary.visionary.repository;

import com.visionary.visionary.domain.Event;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends PagingAndSortingRepository<Event, String>, CustomEventRepository {
}
