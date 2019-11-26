package com.visionary.visionary.repository;

import com.visionary.visionary.controller.filter.EventFilter;
import com.visionary.visionary.domain.Event;
import com.visionary.visionary.domain.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.internal.compile.CriteriaCompiler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Repository
public class CustomSavedEventRepositoryImpl implements CustomSavedEventRepository{

    private final EntityManagerFactory entityManagerFactory;

    @Autowired
    public CustomSavedEventRepositoryImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public List<User> cancelSavedEvent(UUID eventId) {
        String getUsersQuery = "Select * from user u join saved_event se on u.id = se.user_id";
        String cancelAll = "Update saved_event set cancelled = true where event_id = ";
        return new LinkedList<>();
    }
}
