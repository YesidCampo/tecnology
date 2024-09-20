package com.tecnology.domain.ports.in;

import com.tecnology.domain.models.Tecnology;

import reactor.core.publisher.Mono;

public interface CreateTecnologyUseCase {

    Mono<Tecnology> createTecnology(Tecnology tecnology);

}
