package com.itender.api.response;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductMenuResponse {

    private UUID id;

    private String name;

    private Long price;

    private String description;

    private String imageUrl;

}