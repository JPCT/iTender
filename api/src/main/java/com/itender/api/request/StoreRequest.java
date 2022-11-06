package com.itender.api.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class StoreRequest {

    @NotBlank
    private String description;

    @NotNull
    private MultipartFile logoImage;

    @NotBlank
    private String name;
}
