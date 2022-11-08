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

import com.itender.api.request.ItemCategoryRequest;
import com.itender.api.response.ItemCategoryResponse;
import com.itender.exception.ItemCategoryException;
import com.itender.service.ItemCategoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "*", maxAge = 86400)
@RestController
@RequestMapping("/item/category")
@Tag(name = "Item category controller", description = "Item category actions")
public class ItemCategoryController {

    private final ItemCategoryService itemCategoryService;

    @Autowired
    public ItemCategoryController(ItemCategoryService itemCategoryService) {
        this.itemCategoryService = itemCategoryService;
    }

    @Operation(summary = "Create a item category")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "item category created."),
                    @ApiResponse(responseCode = "400", description = "Error in input data.", content = @Content),
                    @ApiResponse(responseCode = "403", description = "Access denied.", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal error.", content = @Content
                    )
            }
    )
    @PostMapping
    public ResponseEntity<UUID> createItemCategory(@NotNull @RequestBody ItemCategoryRequest request) {
        return new ResponseEntity<>(itemCategoryService.createItemCategory(request), HttpStatus.CREATED);
    }

    @Operation(summary = "Update a item category")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "204", description = "item category updated."),
                    @ApiResponse(responseCode = "400", description = "Error in input data.", content = @Content),
                    @ApiResponse(responseCode = "403", description = "Access denied.", content = @Content),
                    @ApiResponse(responseCode = "404", description = "item category not found.", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal error.", content = @Content
                    )
            }
    )
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateItemCategory(@NotNull @PathVariable UUID id,
                                                   @NotNull @RequestBody ItemCategoryRequest request)
            throws ItemCategoryException {
        itemCategoryService.updateItemCategory(id, request);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Delete a item category")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "204", description = "item category deleted."),
                    @ApiResponse(responseCode = "400", description = "Error in input data.", content = @Content),
                    @ApiResponse(responseCode = "403", description = "Access denied.", content = @Content),
                    @ApiResponse(responseCode = "404", description = "item category not found.", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal error.", content = @Content
                    )
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItemCategory(@NotNull @PathVariable UUID id) throws ItemCategoryException {
        itemCategoryService.deleteItemCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Get all item category by store")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "item category retrieved."),
                    @ApiResponse(responseCode = "400", description = "Error in input data.", content = @Content),
                    @ApiResponse(responseCode = "403", description = "Access denied.", content = @Content),
                    @ApiResponse(responseCode = "404", description = "item category not found.", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal error.", content = @Content
                    )
            }
    )
    @GetMapping("/all/{id}")
    public ResponseEntity<List<ItemCategoryResponse>> getAllItemCategoriesByStore(@PathVariable UUID id)
            throws ItemCategoryException {
        return new ResponseEntity<>(itemCategoryService.getItemCategoriesByStore(id), HttpStatus.OK);
    }

}
