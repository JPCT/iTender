package com.itender.bff.domain.store;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreDto {

    private UUID id;
    private String name;
    private String description;
    private String logoUrl;

}
