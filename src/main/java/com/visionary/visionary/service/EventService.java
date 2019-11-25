package com.visionary.visionary.service;

import com.visionary.visionary.controller.error.InvalidTimeException;
import com.visionary.visionary.domain.Event;
import com.visionary.visionary.domain.SavedEvent;
import com.visionary.visionary.domain.User;
import com.visionary.visionary.repository.EventRepository;
import com.visionary.visionary.repository.SavedEventRepository;
import com.visionary.visionary.repository.UserRepository;
import com.visionary.visionary.service.error.NotFoundException;
import com.visionary.visionary.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.*;

@Service
public class EventService {
    private final EventRepository eventRepository;
    private final SavedEventRepository savedEventRepository;
    private final UserService userService;

    @Autowired
    public EventService(EventRepository eventRepository, SavedEventRepository savedEventRepository,
                        UserService userService) {
        this.eventRepository = eventRepository;
        this.savedEventRepository = savedEventRepository;
        this.userService = userService;
    }

    public Event getById(String id) {
        Optional<Event> event = eventRepository.findById(id);
        if (event.isPresent()) {
            return event.get();
        }
        throw new NotFoundException();
    }

    public List<Event> getEvents(Pageable pageable) {
        return eventRepository.findAll(pageable).getContent();
    }

    public Event update(Event event) {
        if (!(ValidationUtil.noVulgarity(event.getTitle()) && ValidationUtil.noVulgarity(event.getDescription()))) {
            throw new IllegalArgumentException("Description or title contains inappropriate language");
        }
        if (event.getStartTime().before(event.getEndTime())) {
            throw new InvalidTimeException("Start time cannot be later than end time");
        }
        if (event.getStartTime().before(Date.from(Instant.now()))) {
            throw new IllegalArgumentException("Cannot create/edit events that have already started");
        }
        CalendarService.updateCalendar(new LinkedList<>(), event);
        //Alert users of event change
        return eventRepository.save(event);
    }

    public void save(String eventId) {
        User user = userService.getCurrentUser();
        Event event = getById(eventId);
        SavedEvent savedEvent = new SavedEvent();
        savedEvent.setCreatedAt(Date.from(Instant.now()));
        savedEvent.setEventId(event.getId());
        savedEvent.setUserId(user.getId());
        savedEventRepository.save(savedEvent);
        event.setSavedCount(savedEventRepository.countByEventId(event.getId()));
        eventRepository.save(event);
        CalendarService.updateCalendar(new LinkedList<>(), event);
    }

    public void unSave(String eventId) {
        Event event = getById(eventId);
        User user = userService.getCurrentUser();
       Optional<SavedEvent> savedEvent = savedEventRepository.findByUserIdAndEventId(user.getId(),eventId);
        if (!savedEvent.isPresent()) {
           return;
        }
        savedEventRepository.deleteById(savedEvent.get().getId());
        event.setSavedCount(savedEventRepository.countByEventId(event.getId()));
        eventRepository.save(event);
        CalendarService.removeFromCalendar(new LinkedList<>(), eventId);
    }

    public Boolean isSaved(String eventId) {
        User user = userService.getCurrentUser();
        if (Objects.nonNull(user)) {
            Optional<SavedEvent> savedEvent = savedEventRepository
                    .findByUserIdAndEventId(user.getId(), eventId);
            return savedEvent.isPresent();
        }
        return false;
    }

    public void cancel(String eventId, String reason) {
        Event event = getById(eventId);
        eventRepository.delete(event);
        savedEventRepository.cancelSavedEvent(eventId)
                .stream()
                .forEach(u -> CalendarService.cancelOnCalendar(new LinkedList<>(), eventId));
        //Alert users of cancellation
    }


}