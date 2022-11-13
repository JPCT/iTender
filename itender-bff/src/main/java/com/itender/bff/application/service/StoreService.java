package com.itender.bff.application.service;

import com.itender.bff.application.port.in.StoreUseCase;
import com.itender.bff.application.port.out.StorePort;
import com.itender.bff.domain.store.StoreDto;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@Slf4j
@ApplicationScoped
public class StoreService implements StoreUseCase {

    @Inject
    StorePort storePort;


    @Override
    public List<StoreDto> getAllStores() {

        return this.storePort.getAllStores();

    }
}
