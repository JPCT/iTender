package com.itender.bff.adapter.in.web.store;

import com.itender.bff.application.port.in.StoreUseCase;
import com.itender.bff.domain.store.StoreDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.CamelContext;
import org.apache.camel.component.google.drive.GoogleDriveClientFactory;
import org.apache.camel.component.google.drive.GoogleDriveComponent;
import org.apache.camel.component.google.drive.GoogleDriveConfiguration;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.support.SimpleRegistry;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import java.util.List;
import java.util.stream.Collectors;

import static javax.ws.rs.core.MediaType.*;
import static javax.ws.rs.core.Response.Status.*;

@Path("/store")
@RequestScoped
@Slf4j
@Produces(APPLICATION_JSON)
@Tag(name = "Store")
public class StoreController {

    private final StoreUseCase storeUseCase;

    @Inject
    public StoreController(StoreUseCase storeUseCase) {
        this.storeUseCase = storeUseCase;
    }

    final GoogleDriveConfiguration configuration = new GoogleDriveConfiguration();


    @GET
    @Path("/all")
    @Operation(summary = "Get store all", description = "Method to get all stores")
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Stores obteined",
                    content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = StoreDto.class))),
            @APIResponse(responseCode = "500", description = "Internal exception"),
            @APIResponse(responseCode = "503", description = "Service unavailable"), })
    public Response getAllStores(){

        List<StoreDto> response = storeUseCase.getAllStores();

        response.stream().forEach(store -> {
            store.setLogoUrl("https://drive.google.com/file/d/1ERlhXoqgNEJUMsFuvEV-LivNlqRxtoVs/view?usp=drivesdk");
        });

        return Response.status(OK).entity(response).build();
    }

}
