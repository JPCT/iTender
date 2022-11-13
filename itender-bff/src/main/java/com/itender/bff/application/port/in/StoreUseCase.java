package com.itender.bff.application.port.in;

import com.itender.bff.domain.store.StoreDto;

import java.util.List;

public interface StoreUseCase {

    List<StoreDto> getAllStores();

}
