package com.itender.api.request;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ProductCategoryRequest {

    @NotBlank
    private String categoryName;

    @NotNull
    private UUID storeId;
}
