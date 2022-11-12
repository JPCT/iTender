package com.itender.service;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.UUID;

import com.itender.api.request.BenchRequest;
import com.itender.api.response.BenchResponse;
import com.itender.exception.BenchException;
import com.itender.model.Bench;

public interface BenchService {

    UUID createBench(BenchRequest request) throws BenchException;

    void deleteBench(UUID id) throws BenchException;

    List<BenchResponse> getAllBenchs() throws BenchException;

    BufferedImage getQRCodeFromBenchId(UUID id) throws BenchException;

}