package com.visionary.visionary.repository;

import com.visionary.visionary.domain.User;

import java.util.List;

public interface CustomSavedEventRepository {

    List<User> cancelSavedEvent(String eventId);
}
