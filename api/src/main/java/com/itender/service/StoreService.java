package com.itender.service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import com.itender.api.request.StoreRequest;
import com.itender.api.response.GetStoreResponse;
import com.itender.exception.FileException;
import com.itender.exception.StoreException;

public interface StoreService {

    Long createStore(StoreRequest request) throws FileException, StoreException;

    void updateStore(Long id, StoreRequest request) throws FileException, StoreException;

    void deleteStore(Long id) throws StoreException;

    List<GetStoreResponse> getAllStores() throws StoreException, FileException, GeneralSecurityException, IOException;
}
