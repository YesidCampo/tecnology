package com.tecnology.application.usecases;

import com.tecnology.domain.models.Tecnology;
import com.tecnology.domain.ports.in.RetrieveTecnologyUseCase;
import com.tecnology.domain.ports.out.TecnologyRepositoryPort;

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

}
