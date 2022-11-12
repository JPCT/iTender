package com.itender.api.rest;

import java.awt.image.BufferedImage;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itender.api.request.BenchRequest;
import com.itender.api.response.BenchResponse;
import com.itender.exception.BenchException;
import com.itender.service.BenchService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "*", maxAge = 86400)
@RestController
@RequestMapping("/bench")
@Tag(name = "Bench controller", description = "Bench actions")
public class BenchController {

    private final BenchService benchService;

    @Autowired
    public BenchController(BenchService benchService) {
        this.benchService = benchService;
    }

    @Operation(summary = "Create a bench")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Bench created."),
                    @ApiResponse(responseCode = "400", description = "Error in input data.", content = @Content),
                    @ApiResponse(responseCode = "403", description = "Access denied.", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal error.", content = @Content
                    )
            }
    )
    @PostMapping
    public ResponseEntity<UUID> createBench(@NotNull @RequestBody BenchRequest request)
            throws BenchException {
        return new ResponseEntity<>(benchService.createBench(request), HttpStatus.CREATED);
    }

    @Operation(summary = "Delete a bench")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "204", description = "Bench deleted."),
                    @ApiResponse(responseCode = "400", description = "Error in input data.", content = @Content),
                    @ApiResponse(responseCode = "403", description = "Access denied.", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Bench not found.", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal error.", content = @Content
                    )
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBench(@NotNull @PathVariable UUID id) throws BenchException {
        benchService.deleteBench(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Get all benchs")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Benchs retrieved."),
                    @ApiResponse(responseCode = "400", description = "Error in input data.", content = @Content),
                    @ApiResponse(responseCode = "403", description = "Access denied.", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Benchs not found.", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal error.", content = @Content
                    )
            }
    )
    @GetMapping("/all")
    public ResponseEntity<List<BenchResponse>> getAllBenchs()
            throws BenchException {
        return new ResponseEntity<>(benchService.getAllBenchs(), HttpStatus.OK);
    }

    @Operation(summary = "Get QR code from a bench")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "QR code from a bench retrieved."),
                    @ApiResponse(responseCode = "400", description = "Error in input data.", content = @Content),
                    @ApiResponse(responseCode = "403", description = "Access denied.", content = @Content),
                    @ApiResponse(responseCode = "404", description = "QR code not found.", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal error.", content = @Content
                    )
            }
    )
    @PostMapping(value = "/qrcode", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<BufferedImage> getQRCodeFromBenchId(@RequestParam UUID id)
            throws BenchException {
        return new ResponseEntity<>(benchService.getQRCodeFromBenchId(id), HttpStatus.OK);
    }
}
