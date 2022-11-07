package com.itender.api.rest;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.UUID;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itender.api.request.StoreRequest;
import com.itender.api.response.GetStoreResponse;
import com.itender.exception.FileException;
import com.itender.exception.StoreException;
import com.itender.service.StoreService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "*", maxAge = 86400)
@RestController
@RequestMapping("/store")
@Tag(name = "Store controller", description = "Store actions")
public class StoreController {

    private final StoreService storeService;

    @Autowired
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @Operation(summary = "Create a store")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Store created."),
                    @ApiResponse(responseCode = "400", description = "Error in input data.", content = @Content),
                    @ApiResponse(responseCode = "403", description = "Access denied.", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal error.", content = @Content
                    )
            }
    )
    @PostMapping(consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<UUID> createStore(@NotNull @ModelAttribute StoreRequest request)
            throws FileException, StoreException {
        return new ResponseEntity<>(storeService.createStore(request), HttpStatus.CREATED);
    }

    @Operation(summary = "Update a store")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "204", description = "Store updated."),
                    @ApiResponse(responseCode = "400", description = "Error in input data.", content = @Content),
                    @ApiResponse(responseCode = "403", description = "Access denied.", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Store not found.", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal error.", content = @Content
                    )
            }
    )
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateStore(@NotNull @PathVariable UUID id, @NotNull @ModelAttribute StoreRequest request)
            throws FileException, StoreException {
        storeService.updateStore(id, request);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Delete a store")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "204", description = "Store deleted."),
                    @ApiResponse(responseCode = "400", description = "Error in input data.", content = @Content),
                    @ApiResponse(responseCode = "403", description = "Access denied.", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Store not found.", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal error.", content = @Content
                    )
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStore(@NotNull @PathVariable UUID id) throws StoreException {
        storeService.deleteStore(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Get all stores")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Stores retrieved."),
                    @ApiResponse(responseCode = "400", description = "Error in input data.", content = @Content),
                    @ApiResponse(responseCode = "403", description = "Access denied.", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Stores not found.", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal error.", content = @Content
                    )
            }
    )
    @GetMapping("/all")
    public ResponseEntity<List<GetStoreResponse>> getAllStores()
            throws FileException, GeneralSecurityException, IOException, StoreException {
        return new ResponseEntity<>(storeService.getAllStores(), HttpStatus.OK);
    }

}
