package com.itender.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itender.model.Store;

public interface StoreRepository extends JpaRepository<Store, UUID> {

    Optional<Store> findByName(String name);
}
