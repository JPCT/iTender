package com.itender.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itender.model.UserApp;

@Repository
public interface UserRepository extends JpaRepository<UserApp, UUID> {

    Optional<UserApp> findByUsername(String username);

}
