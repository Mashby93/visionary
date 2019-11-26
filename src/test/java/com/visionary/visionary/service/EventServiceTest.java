package com.visionary.visionary.service;

import com.visionary.visionary.domain.Event;
import com.visionary.visionary.repository.EventRepository;
import com.visionary.visionary.repository.SavedEventRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestExecution;

@SpringBootTest
public class EventServiceTest {
    private EventService eventService;
    private EventRepository eventRepository = Mockito.mock(EventRepository.class);
    private SavedEventRepository savedEventRepository = Mockito.mock(SavedEventRepository.class);
    private UserService userService = Mockito.mock(UserService.class);


    @BeforeEach
    public void init() {
        eventService = new EventService(eventRepository,savedEventRepository,userService);
    }

    @AfterEach
    public void tearDown() {
        Mockito.clearInvocations(eventRepository,savedEventRepository,userService);
    }

    @Test
    public void testUpdate() {
        Event event = new Event();
        eventService.update(event);
        Mockito.verify(eventRepository, Mockito.times(1)).save(event);
    }


}
