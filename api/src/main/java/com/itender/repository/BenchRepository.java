package com.itender.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itender.model.Bench;

public interface BenchRepository extends JpaRepository<Bench, Long> {

    Optional<Bench> findByTableName(String name);
}
