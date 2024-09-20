package com.tecnology.application.usecases;

import com.tecnology.domain.models.Tecnology;
import com.tecnology.domain.ports.in.CreateTecnologyUseCase;
import com.tecnology.domain.ports.out.TecnologyRepositoryPort;

import reactor.core.publisher.Mono;

public class CreateTecnologyUseCaseImpl implements CreateTecnologyUseCase {

    private final TecnologyRepositoryPort tecnologyRepositoryPort;

    public CreateTecnologyUseCaseImpl(TecnologyRepositoryPort tecnologyRepositoryPort) {
        this.tecnologyRepositoryPort = tecnologyRepositoryPort;
    }

    @Override
    public Mono<Tecnology> createTecnology(Tecnology tecnology) {
        return tecnologyRepositoryPort.save(tecnology);
    }

}
