package com.itender.api.rest;

import java.util.List;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itender.api.request.ProductCategoryRequest;
import com.itender.api.response.ProductCategoryResponse;
import com.itender.exception.ProductCategoryException;
import com.itender.service.ProductCategoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "*", maxAge = 86400)
@RestController
@RequestMapping("/category/product")
@Tag(name = "Product category controller", description = "Product category actions")
public class ProductCategoryController {

    private final ProductCategoryService productCategoryService;

    @Autowired
    public ProductCategoryController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @Operation(summary = "Create a product category")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Product category created."),
                    @ApiResponse(responseCode = "400", description = "Error in input data.", content = @Content),
                    @ApiResponse(responseCode = "403", description = "Access denied.", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal error.", content = @Content
                    )
            }
    )
    @PostMapping
    public ResponseEntity<UUID> createProductCategory(@NotNull @RequestBody ProductCategoryRequest request) {
        return new ResponseEntity<>(productCategoryService.createProductCategory(request), HttpStatus.CREATED);
    }

    @Operation(summary = "Update a product category")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "204", description = "Product category updated."),
                    @ApiResponse(responseCode = "400", description = "Error in input data.", content = @Content),
                    @ApiResponse(responseCode = "403", description = "Access denied.", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Product category not found.", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal error.", content = @Content
                    )
            }
    )
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateProductCategory(@NotNull @PathVariable UUID id,
                                                      @NotNull @RequestBody ProductCategoryRequest request)
            throws ProductCategoryException {
        productCategoryService.updateProductCategory(id, request);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Delete a product category")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "204", description = "Product category deleted."),
                    @ApiResponse(responseCode = "400", description = "Error in input data.", content = @Content),
                    @ApiResponse(responseCode = "403", description = "Access denied.", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Product category not found.", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal error.", content = @Content
                    )
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductCategory(@NotNull @PathVariable UUID id) throws ProductCategoryException {
        productCategoryService.deleteProductCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Get all product category by store")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Product category retrieved."),
                    @ApiResponse(responseCode = "400", description = "Error in input data.", content = @Content),
                    @ApiResponse(responseCode = "403", description = "Access denied.", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Product category not found.", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal error.", content = @Content
                    )
            }
    )
    @GetMapping("/all/{id}")
    public ResponseEntity<List<ProductCategoryResponse>> getAllProductCategoriesByStore(@PathVariable UUID id)
            throws ProductCategoryException {
        return new ResponseEntity<>(productCategoryService.getProductCategoriesByStore(id), HttpStatus.OK);
    }

}
