package com.tecnology.domain.ports.in;

import com.tecnology.domain.models.Tecnology;

import reactor.core.publisher.Mono;

public interface RetrieveTecnologyUseCase {

    Mono<Tecnology> getTecnologyByName(String name);

}
