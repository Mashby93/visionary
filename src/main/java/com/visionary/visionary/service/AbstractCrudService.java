package com.visionary.visionary.service;

import com.visionary.visionary.domain.AbstractAuditEntity;
import com.visionary.visionary.domain.AbstractEntity;
import com.visionary.visionary.repository.BaseRepository;
import com.visionary.visionary.util.UUIDGenerator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public abstract class AbstractCrudService<T extends AbstractEntity> {
    private final BaseRepository<T> repository;

    protected <R extends BaseRepository<T>> AbstractCrudService(R repository) {
        this.repository = repository;
    }

    public T getOne(String id) {
        return getById(id)
                .orElseThrow(() -> new IllegalArgumentException());
    }

    public Optional<T> getById(String id) {
        return repository.findById(id);
    }

    public Collection<T> getAllById(List<String> idList) {
        if (null == idList || idList.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return repository.findAllById(idList);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public Collection<T> saveAll(List<T> entities) {
        return repository.saveAll(entities);
    }

    public T save(T entity) {
        Long timestamp = System.currentTimeMillis();

        if (null == entity.getId()) {
            entity.setId(UUIDGenerator.generate());
        }

        if (entity instanceof AbstractAuditEntity) {
            if (!repository.existsById(entity.getId())) {
                ((AbstractAuditEntity) entity).setCreatedAt(timestamp);
            }

            ((AbstractAuditEntity) entity).setUpdatedAt(timestamp);
        }


        return repository.save(entity);
    }

    public List<T> getAll() {
        return repository.findAll();
    }

    public Page<T> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
