package com.itender.api.rest;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itender.api.request.ProductRequest;
import com.itender.api.response.ProductResponse;
import com.itender.exception.FileException;
import com.itender.exception.ProductException;
import com.itender.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "*", maxAge = 86400)
@RestController
@RequestMapping("/product")
@Tag(name = "Product controller", description = "Product actions")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(summary = "Create a product")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Product created."),
                    @ApiResponse(responseCode = "400", description = "Error in input data.", content = @Content),
                    @ApiResponse(responseCode = "403", description = "Access denied.", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal error.", content = @Content
                    )
            }
    )
    @PostMapping(consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<UUID> createProduct(@ModelAttribute @Valid ProductRequest request)
            throws ProductException, FileException {
        return new ResponseEntity<>(productService.createProduct(request), HttpStatus.CREATED);
    }

    @Operation(summary = "Get a product")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Product retrieved."),
                    @ApiResponse(responseCode = "400", description = "Error in input data.", content = @Content),
                    @ApiResponse(responseCode = "403", description = "Access denied.", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal error.", content = @Content
                    )
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProduct(@NotBlank @PathVariable UUID id)
            throws FileException, GeneralSecurityException, IOException, ProductException {
        return new ResponseEntity<>(productService.getProduct(id), HttpStatus.OK);
    }

    @Operation(summary = "Delete a product")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "204", description = "Product deleted."),
                    @ApiResponse(responseCode = "400", description = "Error in input data.", content = @Content),
                    @ApiResponse(responseCode = "403", description = "Access denied.", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Store not found.", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal error.", content = @Content
                    )
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@NotNull @PathVariable UUID id) throws ProductException {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
