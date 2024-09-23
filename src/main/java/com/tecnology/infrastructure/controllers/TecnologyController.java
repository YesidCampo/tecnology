package com.tecnology.infrastructure.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tecnology.application.services.TecnologyService;
import com.tecnology.domain.models.Tecnology;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/tecnology")
public class TecnologyController {

    private final TecnologyService tecnologyService;

    public TecnologyController(TecnologyService tecnologyService) {
        this.tecnologyService = tecnologyService;
    }

    @PostMapping("/")
    @Operation(summary = "Create Tecnology", description = "Save Tecnology in the system. **Warning:**  no empty name or more than 50 characters is allowed, no empty description or more than 90 characters is allowed.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Tecnology saved correctly"),
            @ApiResponse(responseCode = "400", description = "Bad request: Tecnology Not Created or Bad request: The field is empty or Tecnology not created due to duplicate name or The field is not valid format", content = @Content(mediaType = "text/plain", schema = @Schema(type = "string"))),
    })
    public Mono<Tecnology> createTecnology(
            @RequestBody @Schema(example = "{\"name\": \"java\",\"description\": \"java\"}") Tecnology tecnology) {
        return this.tecnologyService.createTecnology(tecnology);
    }

    @GetMapping("/technologies")
    @Operation(summary = "Get All Technologies", description = "Return all Technologies of system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Technologies data found."),
            @ApiResponse(responseCode = "400", description = "Bad request: Not found Technologies", content = @Content(mediaType = "text/plain", schema = @Schema(type = "string"))),
    })
    public Flux<Tecnology> getAllTecnology(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "true") boolean ascending) {
        Pageable pageable = PageRequest.of(page, size);
        return this.tecnologyService.getAllTecnology(pageable, ascending);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Technology", description = "Return Technology by Id of system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Technology data found."),
            @ApiResponse(responseCode = "400", description = "Bad request: Not found Technology", content = @Content(mediaType = "text/plain", schema = @Schema(type = "string"))),
    })
    public Mono<Tecnology> getTecnologyById(@PathVariable Long id) {
        return this.tecnologyService.getTecnologyById(id);
    }

    @PostMapping("/technologies/ids")
    @Operation(summary = "Get All Technologies By Ids", description = "Return all Technologies of system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Technologies data found."),
            @ApiResponse(responseCode = "400", description = "Bad request: Not found Technologies", content = @Content(mediaType = "text/plain", schema = @Schema(type = "string"))),
    })
    public Flux<Tecnology> getAllTecnologyByIds(@RequestBody List<Long> ids) {
        return this.tecnologyService.getTecnologiesByIds(ids);
    }

}
