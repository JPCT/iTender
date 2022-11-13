package com.itender.bff.application.port.out;

import com.itender.bff.domain.store.StoreDto;

import java.util.List;

public interface StorePort {

    List<StoreDto> getAllStores();
}
