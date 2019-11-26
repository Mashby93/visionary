package com.visionary.visionary.repository;

import com.visionary.visionary.controller.filter.EventFilter;
import com.visionary.visionary.domain.Event;
import org.hibernate.Criteria;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Objects;

public class CustomEventRepositoryImpl implements CustomEventRepository{

    private final EntityManagerFactory entityManagerFactory;

    public CustomEventRepositoryImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

}
