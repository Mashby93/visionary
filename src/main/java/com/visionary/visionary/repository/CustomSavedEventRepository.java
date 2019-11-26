package com.visionary.visionary.repository;

import com.visionary.visionary.domain.User;

import java.util.List;
import java.util.UUID;

public interface CustomSavedEventRepository {

    List<User> cancelSavedEvent(UUID eventId);
}
