package com.itender.bff.adapter.out.client;

import com.itender.bff.application.port.out.StorePort;
import com.itender.bff.domain.store.StoreDto;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;


@ApplicationScoped
@Slf4j
public class StoreAdapter implements StorePort {

    private final StoreRestClient storeRestClient;

    @Inject
    public StoreAdapter(@RestClient StoreRestClient storeRestClient) {
        this.storeRestClient = storeRestClient;
    }

    @Override
    public List<StoreDto> getAllStores() {
        return this.storeRestClient.getStores();
    }

}
