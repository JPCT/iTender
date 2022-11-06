package com.itender.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itender.model.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {

    Optional<Store> findByName(String name);
}
