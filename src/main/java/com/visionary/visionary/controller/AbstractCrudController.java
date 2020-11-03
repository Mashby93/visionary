package com.visionary.visionary.controller;

import com.visionary.visionary.domain.AbstractEntity;
import com.visionary.visionary.service.AbstractCrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

public class AbstractCrudController<T extends AbstractEntity, S extends AbstractCrudService<T>> {

    private final S service;

    protected AbstractCrudController(S service) {
        this.service = service;
    }

    @GetMapping("")
    public ResponseEntity<Page<T>> getAll(Pageable pageable) {
        return ResponseEntity.ok(service.getAll(pageable));
    }

    @PostMapping("")
    public ResponseEntity<T> save(@RequestBody T entity) {
        return ResponseEntity.ok((T) service.save(entity));
    }

    @GetMapping("/bulk")
    public Collection<T> getAllBulk() {
        return service.getAll();
    }

    @PostMapping("/bulk")
    public ResponseEntity<Collection<T>> saveAll(@RequestBody List<T> entities) {
        return ResponseEntity.ok(service.saveAll(entities));
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> getById(@PathVariable("id") String id) {
        return ResponseEntity.ok((T) service.getOne(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable("id") String id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
