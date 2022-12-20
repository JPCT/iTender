package com.itender.service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.UUID;

import com.itender.api.request.ProductRequest;
import com.itender.api.response.ProductResponse;
import com.itender.exception.FileException;
import com.itender.exception.ProductException;

public interface ProductService {

    UUID createProduct(ProductRequest request) throws FileException, ProductException;

    ProductResponse getProduct(UUID id) throws FileException, GeneralSecurityException, IOException, ProductException;

    void deleteProduct(UUID productId) throws ProductException;

}
