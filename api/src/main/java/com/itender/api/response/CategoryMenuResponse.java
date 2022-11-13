package com.itender.api.response;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryMenuResponse {

    private UUID id;

    private String categoryName;

    private List<ProductMenuResponse> productList;

}
