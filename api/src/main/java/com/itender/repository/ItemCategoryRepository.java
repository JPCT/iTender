package com.itender.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itender.model.ItemCategory;

public interface ItemCategoryRepository extends JpaRepository<ItemCategory, UUID> {

    List<ItemCategory> getItemCategoriesByStoreId(UUID storeId);

}
