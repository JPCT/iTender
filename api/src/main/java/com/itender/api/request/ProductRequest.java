package com.itender.api.request;

import java.util.UUID;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ProductRequest {

    @NotBlank
    private String name;

    @Min(1L)
    @NotNull
    private Long price;

    @NotBlank
    private String description;

    @NotNull
    private MultipartFile image;

    @NotNull
    private UUID productCategoryId;

    @NotNull
    private UUID storeId;

}
