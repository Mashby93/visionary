package com.visionary.visionary.repository;

import com.visionary.visionary.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.LinkedList;
import java.util.List;

@Repository
public class CustomSavedEventRepositoryImpl implements CustomSavedEventRepository{

    private final DataSource dataSource;

    public CustomSavedEventRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<User> cancelSavedEvent(String eventId) {
        String getUsersQuery = "Select * from user u join saved_event se on u.id = se.user_id";
        String cancelAll = "Update saved_event set cancelled = true where event_id = ";
        return new LinkedList<>();
    }
}
