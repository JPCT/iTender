package com.itender.service;

import java.util.List;
import java.util.UUID;

import com.itender.api.request.ProductCategoryRequest;
import com.itender.api.response.ProductCategoryResponse;
import com.itender.exception.ProductCategoryException;

public interface ProductCategoryService {

    UUID createProductCategory(ProductCategoryRequest request);

    void updateProductCategory(UUID id, ProductCategoryRequest request) throws ProductCategoryException;

    void deleteProductCategory(UUID id) throws ProductCategoryException;

    List<ProductCategoryResponse> getProductCategoriesByStore(UUID storeId) throws ProductCategoryException;

}
