package com.itender.bff.domain.store;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Store {

    private UUID id;
    private String name;
    private String description;
    private String logoImageId;
    private String createdAt;

}
