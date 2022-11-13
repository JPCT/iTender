package com.itender.service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.UUID;

import com.itender.api.request.StoreRequest;
import com.itender.api.response.GetStoreResponse;
import com.itender.api.response.MenuResponse;
import com.itender.exception.FileException;
import com.itender.exception.ProductCategoryException;
import com.itender.exception.ProductException;
import com.itender.exception.StoreException;

public interface StoreService {

    UUID createStore(StoreRequest request) throws FileException, StoreException;

    void updateStore(UUID id, StoreRequest request) throws FileException, StoreException;

    void deleteStore(UUID id) throws StoreException;

    List<GetStoreResponse> getAllStores() throws StoreException, FileException, GeneralSecurityException, IOException;

    MenuResponse getMenuFromStore(UUID id) throws StoreException, ProductCategoryException,
            ProductException, FileException, GeneralSecurityException, IOException;

}
