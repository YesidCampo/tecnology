package com.tecnology.application.usecases;

import org.springframework.data.domain.Pageable;

import com.tecnology.domain.models.Tecnology;
import com.tecnology.domain.ports.in.RetrieveTecnologyUseCase;
import com.tecnology.domain.ports.out.TecnologyRepositoryPort;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class RetrieveTecnologyUseCaseImpl implements RetrieveTecnologyUseCase {

    private final TecnologyRepositoryPort tecnologyRepositoryPort;

    public RetrieveTecnologyUseCaseImpl(TecnologyRepositoryPort tecnologyRepositoryPort) {
        this.tecnologyRepositoryPort = tecnologyRepositoryPort;
    }

    @Override
    public Mono<Tecnology> getTecnologyByName(String name) {
        return this.tecnologyRepositoryPort.findByName(name);
    }

    @Override
    public Flux<Tecnology> getAllTecnology(Pageable pageable, boolean ascending) {
        return this.tecnologyRepositoryPort.findAll(pageable, ascending);
    }

}
