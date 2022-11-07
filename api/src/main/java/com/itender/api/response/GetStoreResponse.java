package com.itender.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetStoreResponse {

    private Long id;

    private String name;

    private String description;

    private String logoUrl;

}
