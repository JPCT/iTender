package com.itender.service;

import java.util.UUID;

import com.itender.api.request.BenchRequest;
import com.itender.exception.BenchException;

public interface BenchService {

    UUID createBench(BenchRequest request) throws BenchException;

    void deleteBench(UUID id) throws BenchException;

}