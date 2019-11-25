package com.visionary.visionary.repository;

import com.visionary.visionary.domain.SavedEvent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SavedEventRepository extends CrudRepository<SavedEvent, String>, CustomSavedEventRepository {
    long countByEventId(String userId);

    Optional<SavedEvent> findByUserIdAndEventId(String userId, String eventId);
    List<SavedEvent> findByEventId(String eventId);
}
