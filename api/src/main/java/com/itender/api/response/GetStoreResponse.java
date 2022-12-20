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
public class GetStoreResponse {

    private UUID id;

    private String name;

    private String description;

    private String logoUrl;

}
