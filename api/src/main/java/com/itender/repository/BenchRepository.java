package com.itender.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itender.model.Bench;

public interface BenchRepository extends JpaRepository<Bench, UUID> {

    Optional<Bench> findByTableName(String name);
}
