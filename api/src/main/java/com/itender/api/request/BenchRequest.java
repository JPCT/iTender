package com.itender.api.request;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class BenchRequest {

    @NotBlank
    private String tableName;

}
