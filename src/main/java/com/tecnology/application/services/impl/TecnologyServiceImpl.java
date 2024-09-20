package com.tecnology.application.services.impl;

import java.util.Comparator;

import org.springframework.data.domain.Pageable;

import com.tecnology.application.services.TecnologyService;
import com.tecnology.domain.exception.NotValidFieldException;
import com.tecnology.domain.models.Tecnology;
import com.tecnology.domain.ports.in.CreateTecnologyUseCase;
import com.tecnology.domain.ports.in.RetrieveTecnologyUseCase;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class TecnologyServiceImpl implements TecnologyService {

    private final CreateTecnologyUseCase createTecnologyUseCase;
    private final RetrieveTecnologyUseCase retrieveTecnologyUseCase;

    public TecnologyServiceImpl(CreateTecnologyUseCase createTecnologyUseCase,
            RetrieveTecnologyUseCase retrieveTecnologyUseCase) {
        this.createTecnologyUseCase = createTecnologyUseCase;
        this.retrieveTecnologyUseCase = retrieveTecnologyUseCase;
    }

    @Override
    public Mono<Tecnology> createTecnology(Tecnology tecnology) {

        if (tecnology.getName().isBlank() || tecnology.getName().length() > 50) {
            return Mono.error(new NotValidFieldException("Tecnology name is not valid"));
        }

        if (tecnology.getDescription().isBlank() || tecnology.getDescription().length() > 90) {
            return Mono.error(new NotValidFieldException("Tecnology description is not valid"));
        }

        return getTecnologyByName(tecnology.getName())
                .flatMap(exist -> Mono.error(new NotValidFieldException("Tecnology name already exists")))
                .switchIfEmpty(this.createTecnologyUseCase.createTecnology(tecnology)
                        .switchIfEmpty(Mono.error(new Exception("Tecnology not created"))))
                .map(Tecnology.class::cast)
                .onErrorMap(Exception.class, ex -> new Exception(ex.getMessage()));

    }

    @Override
    public Mono<Tecnology> getTecnologyByName(String name) {
        return this.retrieveTecnologyUseCase.getTecnologyByName(name);
    }

    @Override
    public Flux<Tecnology> getAllTecnology(Pageable pageable, boolean ascending) {
        return this.retrieveTecnologyUseCase.getAllTecnology(pageable, ascending)
                .sort(ascending
                        ? Comparator.comparing(Tecnology::getName)
                        : Comparator.comparing(Tecnology::getName).reversed())
                .skip(pageable.getPageNumber() * pageable.getPageSize())
                .take(pageable.getPageSize());
    }

}
