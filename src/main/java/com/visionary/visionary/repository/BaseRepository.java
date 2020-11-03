package com.visionary.visionary.repository;

import com.visionary.visionary.domain.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepository<T extends AbstractEntity> extends JpaRepository<T, String> {
}
