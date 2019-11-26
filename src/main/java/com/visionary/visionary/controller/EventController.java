package com.visionary.visionary.controller;

import com.visionary.visionary.controller.pagination.Pagination;
import com.visionary.visionary.controller.param.ReportReason;
import com.visionary.visionary.mapper.EventMapper;
import com.visionary.visionary.model.EventDto;
import com.visionary.visionary.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class EventController {
    private final EventService eventService;
    private final EventMapper eventMapper;
    private final Sort defaultSort = Sort.by("createdAt").descending();

    @Autowired
    public EventController(EventService eventService, EventMapper eventMapper) {
        this.eventService = eventService;
        this.eventMapper = eventMapper;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/")
    public List<EventDto> getEvents(Pagination pageable) {
        return eventService.getEvents(pageable.convert(defaultSort))
                .stream()
                .map(eventMapper::toDto)
                .collect(Collectors.toList());
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/")
    public void updateEvent(EventDto eventDto) {
        eventService.update(eventMapper.toEntity(eventDto));
    }

    @PatchMapping("/{eventId}/report")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void reportEvent(@PathVariable("eventId") UUID id, @RequestBody ReportReason reportReason) {
        eventService.report(id, reportReason);
    }

    @DeleteMapping("/{eventId}/cancel")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void cancelEvent(@PathVariable("eventId") UUID id, @RequestBody String cancelReason) {
        eventService.cancel(id, cancelReason);
    }
}
