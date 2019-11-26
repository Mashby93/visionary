package com.visionary.visionary.repository;

import com.visionary.visionary.domain.SavedEvent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SavedEventRepository extends CrudRepository<SavedEvent, UUID>, CustomSavedEventRepository {
    long countByEventId(UUID userId);

    Optional<SavedEvent> findBycreatedByAndEventId(UUID userId, UUID eventId);
    List<SavedEvent> findByEventId(UUID eventId);
}
