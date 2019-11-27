package com.visionary.visionary.mapper;

import com.fasterxml.uuid.Generators;
import com.visionary.visionary.config.Constants;
import com.visionary.visionary.controller.error.InvalidTimeException;
import com.visionary.visionary.domain.Category;
import com.visionary.visionary.domain.Event;
import com.visionary.visionary.model.CategoryDto;
import com.visionary.visionary.model.EventDto;
import com.visionary.visionary.service.CategoryService;
import com.visionary.visionary.service.EventService;
import org.modelmapper.ModelMapper;
import org.omg.CORBA.DynAnyPackage.Invalid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class EventMapper {
    private final EventService eventService;
    private final ModelMapper modelMapper;
    private final CategoryMapper categoryMapper;
    private final CategoryService categoryService;
    private final UserMapper userMapper;

    @Autowired
    public EventMapper(EventService eventService, ModelMapper modelMapper, CategoryMapper categoryMapper,
                       CategoryService categoryService, UserMapper userMapper) {
        this.eventService = eventService;
        this.modelMapper = modelMapper;
        this.categoryMapper = categoryMapper;
        this.categoryService = categoryService;
        this.userMapper = userMapper;
    }


    public EventDto toDto(Event event) {
        EventDto dto = modelMapper.map(event, EventDto.class);
        dto.setUserProfile(userMapper.publicUserProfileDto(event.getUser()));
        dto.setStartTime(event.getStartTime().toString());
        dto.setEndTime(event.getEndTime().toString());
        dto.setCategoryDto(categoryMapper.toDto(event.getCategoryId()));
        dto.setSaved(eventService.isSaved(event.getId()));
        dto.setSavedCount(event.getSavedCount());
        return dto;
    }

    public Event toEntity(EventDto eventDto) {
        Event event = modelMapper.map(eventDto,Event.class);
        event.setSavedCount(0L);
        if (Objects.nonNull(eventDto.getId())) {
            Event oldEvent = eventService.getById(eventDto.getId());
            event.setUser(oldEvent.getUser());
            event.setSavedCount(oldEvent.getSavedCount());
            if (!event.getLocation().getAddress().equalsIgnoreCase(oldEvent.getLocation().getAddress())) {
                // calculate lat/long
            }
            if (Objects.nonNull(eventDto.getCategoryDto()) &&
                    !oldEvent.getCategoryId().equals(eventDto.getCategoryDto().getId())) {
                event.setCategoryId(categoryService.getById(eventDto.getCategoryDto().getId()));
            }
            try {
                event.setStartTime(Constants.DATE_FORMAT.parse(eventDto.getStartTime()));
                event.setEndTime(Constants.DATE_FORMAT.parse(eventDto.getEndTime()));
            } catch (ParseException parseException) {
                throw new InvalidTimeException("Invalid start time or end time format");
            }
        } else {
            event.setId(Generators.timeBasedGenerator().generate());
        }
        return event;
    }

}
