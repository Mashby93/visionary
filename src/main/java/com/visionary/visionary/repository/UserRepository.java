package com.visionary.visionary.repository;

import com.visionary.visionary.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, UUID> {

    Optional<User> findByEmailAddress(String email);
    Boolean existsByEmailAddress(String email);
}
