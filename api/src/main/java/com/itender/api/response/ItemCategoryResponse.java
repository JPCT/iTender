package com.itender.api.response;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemCategoryResponse {

    private UUID id;

    private String categoryName;

    private UUID storeId;

}
