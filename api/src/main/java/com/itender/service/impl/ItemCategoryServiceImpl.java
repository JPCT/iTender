package com.itender.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.itender.api.request.ItemCategoryRequest;
import com.itender.api.response.ItemCategoryResponse;
import com.itender.exception.ItemCategoryException;
import com.itender.model.ItemCategory;
import com.itender.repository.ItemCategoryRepository;
import com.itender.service.ItemCategoryService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ItemCategoryServiceImpl implements ItemCategoryService {

    private final ItemCategoryRepository itemCategoryRepository;
    private final ModelMapper mapper;

    @Autowired
    public ItemCategoryServiceImpl(ItemCategoryRepository itemCategoryRepository, ModelMapper mapper) {
        this.itemCategoryRepository = itemCategoryRepository;
        this.mapper = mapper;
    }

    @Override
    public UUID createItemCategory(ItemCategoryRequest request) {
        ItemCategory itemCategory = mapper.map(request, ItemCategory.class);
        log.info("Creating product category {}", itemCategory.getName());

        itemCategoryRepository.save(itemCategory);

        return itemCategory.getId();
    }

    @Override
    public void updateItemCategory(UUID id, ItemCategoryRequest request) throws ItemCategoryException {
        Optional<ItemCategory> optionalItemCategory = itemCategoryRepository.findById(id);

        if (optionalItemCategory.isPresent()) {
            mapper.map(request, optionalItemCategory.get());
            log.info("Updating product category {}", optionalItemCategory.get().getName());
            optionalItemCategory.get().setId(id);

            itemCategoryRepository.save(optionalItemCategory.get());
        } else {
            throw new ItemCategoryException("Item category with id " + id + " not exists.", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteItemCategory(UUID id) throws ItemCategoryException {
        Optional<ItemCategory> optionalItemCategory = itemCategoryRepository.findById(id);

        if (optionalItemCategory.isPresent()) {
            log.info("Deleting item category {}", optionalItemCategory.get().getName());

            itemCategoryRepository.deleteById(id);
        } else {
            throw new ItemCategoryException("Item category with id " + id + " not exists.", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public List<ItemCategoryResponse> getItemCategoriesByStore(UUID storeId) throws ItemCategoryException {
        List<ItemCategory> itemCategories = itemCategoryRepository.getItemCategoriesByStoreId(storeId);

        if (!itemCategories.isEmpty()) {
            List<ItemCategoryResponse> itemCategoryResponses = new ArrayList<>();
            for (ItemCategory itemCategory : itemCategories) {
                ItemCategoryResponse itemCategoryResponse = mapper.map(itemCategory, ItemCategoryResponse.class);
                itemCategoryResponses.add(itemCategoryResponse);
            }

            return itemCategoryResponses;
        } else {
            throw new ItemCategoryException("Any item category was found with store id " + storeId + " .",
                    HttpStatus.NOT_FOUND);
        }
    }

}
