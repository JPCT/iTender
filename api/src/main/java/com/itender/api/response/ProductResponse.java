package com.itender.api.response;

import java.util.UUID;

import lombok.Data;

@Data
public class ProductResponse {

    private UUID id;

    private String name;

    private Long price;

    private String description;

    private String imageUrl;

    private ProductCategoryResponse productCategory;

    private GetStoreResponse store;

}
