package com.itender.service;

import com.itender.api.request.BenchRequest;
import com.itender.exception.BenchException;

public interface BenchService {

    Long createBench(BenchRequest request) throws BenchException;

    void deleteBench(Long id) throws BenchException;

}