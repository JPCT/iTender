package com.itender.service.impl;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.itender.api.request.BenchRequest;
import com.itender.api.response.BenchResponse;
import com.itender.exception.BenchException;
import com.itender.model.Bench;
import com.itender.repository.BenchRepository;
import com.itender.service.BenchService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BenchServiceImpl implements BenchService {

    private final BenchRepository benchRepository;
    private final ModelMapper mapper;
    private final Clock clock;

    @Autowired
    public BenchServiceImpl(BenchRepository benchRepository, ModelMapper modelMapper, Clock clock) {
        this.benchRepository = benchRepository;
        this.mapper = modelMapper;
        this.clock = clock;
    }

    @Override
    public UUID createBench(BenchRequest request) throws BenchException {
        if (!benchRepository.findByTableName(request.getTableName()).isPresent()) {

            Bench bench = mapper.map(request, Bench.class);
            bench.setCreatedAt(LocalDateTime.now(clock));
            log.info("Creating bench {}", bench.getTableName());

            benchRepository.save(bench);

            return bench.getId();
        } else {
            throw new BenchException(String.format("Bench with name %s already exists.", request.getTableName()),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public void deleteBench(UUID id) throws BenchException {
        Optional<Bench> optionalBench = benchRepository.findById(id);

        if (optionalBench.isPresent()) {
            log.info("Deleting bench {}", optionalBench.get().getTableName());

            benchRepository.deleteById(id);
        } else {
            throw new BenchException(String.format("Bench with id %s not exists.", id), HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public List<BenchResponse> getAllBenchs() throws BenchException {
        List<Bench> benchList = benchRepository.findAll();

        if(!benchList.isEmpty()){
            List<BenchResponse> benchResponseList;
            benchResponseList = benchList.stream()
                    .map(bench ->
                        mapper.map(bench, BenchResponse.class)
            ).collect(Collectors.toList());

            return benchResponseList;
        } else {
            throw new BenchException("Any bench was not found.", HttpStatus.NOT_FOUND);
        }
    }

}
