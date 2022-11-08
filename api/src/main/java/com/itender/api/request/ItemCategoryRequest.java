package com.itender.api.request;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ItemCategoryRequest {

    @NotBlank
    private String name;

    @NotNull
    private UUID storeId;
}
