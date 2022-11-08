package com.itender.service;

import java.util.List;
import java.util.UUID;

import com.itender.api.request.ItemCategoryRequest;
import com.itender.api.response.ItemCategoryResponse;
import com.itender.exception.ItemCategoryException;

public interface ItemCategoryService {

    UUID createItemCategory(ItemCategoryRequest request);

    void updateItemCategory(UUID id, ItemCategoryRequest request) throws ItemCategoryException;

    void deleteItemCategory(UUID id) throws ItemCategoryException;

    List<ItemCategoryResponse> getItemCategoriesByStore(UUID storeId) throws ItemCategoryException;
}
